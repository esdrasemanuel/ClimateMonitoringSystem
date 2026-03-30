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

        double riverLevel = 3 + random.nextDouble() * 1.5; // 3 to 5.0
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
                    + ": " + rainfallData.getRainfallAmount() + " mm at "
                    + rainfallData.getTimestamp());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error receiving data: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                double averageRainfall = (count == 0) ? 0 : totalRainfall / count;

                String floodRiskIndicator;
                if (averageRainfall < 2.0) {
                    floodRiskIndicator = "Low";
                } else if (averageRainfall < 5.0) {
                    floodRiskIndicator = "Medium";
                } else {
                    floodRiskIndicator = "High";
                }

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
    public StreamObserver<RiverRequest> monitorRiverLevelLive(StreamObserver<RiverResponse> responseObserver) {

        ServerCallStreamObserver<RiverResponse> serverObserver =
            (ServerCallStreamObserver<RiverResponse>) responseObserver;

        return new StreamObserver<RiverRequest>() {

            double riverLevel = 3.8; // initial level

            @Override
            public void onNext(RiverRequest request) {
                if (!serverObserver.isCancelled()) {

                    // small realistic changes
                    riverLevel += (random.nextDouble() - 0.5) * 0.2;
                    riverLevel = Math.max(2.5, Math.min(5.5, riverLevel));

                    String riskStatus = determineRiskStatus(riverLevel);

                    RiverResponse response = RiverResponse.newBuilder()
                            .setRiverLevel(riverLevel)
                            .setRiskStatus(riskStatus)
                            .setTimestamp(LocalDateTime.now().toString())
                            .build();

                    responseObserver.onNext(response);
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
        if (riverLevel < 3.8) {
            return "Low";
        } else if (riverLevel < 4.5) {
            return "Moderate";
        } else {
            return "High";
        }
    }
}
