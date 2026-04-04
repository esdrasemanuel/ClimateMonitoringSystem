/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esdras.server;

import com.esdras.river.*;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * @author EMoreira
 */


public class RiverLevelServiceImpl extends RiverLevelServiceGrpc.RiverLevelServiceImplBase {

    private final Random random = new Random();

    // 1. Simple RPC
    @Override
    public void getCurrentRiverLevel(RiverRequest request, StreamObserver<RiverResponse> responseObserver) {

        double riverLevel = 1 + random.nextDouble() * 1.5; // 1 to 5.0
        String riskStatus = determineRiskStatus(riverLevel);

        RiverResponse response = RiverResponse.newBuilder()
            .setRiverLevel(riverLevel)
            .setRiskStatus(riskStatus)
            .setTimestamp(LocalDateTime.now().toString())
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // 2. Client Streaming RPC
    @Override
    public StreamObserver<RainfallData> uploadRainfallData(StreamObserver<RainfallAnalysis> responseObserver) {

        return new StreamObserver<RainfallData>() {

            int count = 0;
            double totalRainfall = 0;

            @Override
            public void onNext(RainfallData rainfallData) {
                count++;
                totalRainfall += rainfallData.getRainfallAmount();

                System.out.println("Received rainfall from " + rainfallData.getLocation()
                    + ": " + rainfallData.getRainfallAmount());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error receiving data: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                double averageRainfall = (count == 0) ? 0 : totalRainfall / count;
                String floodRiskIndicator = determineFloodRisk(averageRainfall);

                RainfallAnalysis analysis = RainfallAnalysis.newBuilder()
                    .setAverageRainfall(averageRainfall)
                    .setFloodRiskIndicator(floodRiskIndicator)
                    .build();

                responseObserver.onNext(analysis);
                responseObserver.onCompleted();
            }
        };
    }

    // 3. Bidirectional Streaming RPC
    @Override
    public StreamObserver<RiverRequestBidi> monitorRiverLevelLive(StreamObserver<RiverResponse> responseObserver) {

        ServerCallStreamObserver<RiverResponse> serverObserver =
            (ServerCallStreamObserver<RiverResponse>) responseObserver;

        return new StreamObserver<RiverRequestBidi>() {

            @Override
            public void onNext(RiverRequestBidi request) {
                if (!serverObserver.isCancelled()) { 

                    // level comes from client (it simules client comunication)
                    double riverLevel = request.getRiverLevel();

                    String riskStatus = determineRiskStatus(riverLevel);

                    RiverResponse response = RiverResponse.newBuilder()
                            .setRiverLevel(riverLevel)
                            .setRiskStatus(riskStatus)
                            .setTimestamp(LocalDateTime.now().toString())
                            .build();

                    responseObserver.onNext(response); // send response
                }
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("live stream error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("live monitoring ended.");
                responseObserver.onCompleted();
            }
        };
    }
    // method to determine the risks:
    private String determineRiskStatus(double riverLevel) {
        if (riverLevel < 1.5) {
            return "Low";
        } else if (riverLevel < 3.0) {
            return "Moderate";
        } else {
            return "High";
        }
    }
    
    // method to determine the risks of flood:
    private String determineFloodRisk(double averageRainfall) {
        if (averageRainfall < 10) {
            return "Low";
        } else if (averageRainfall < 15) {
            return "Medium";
        } else {
            return "High";
        }
    }
    
}
