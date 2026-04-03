/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esdras.client;
import com.esdras.river.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author EMoreira
 */

public class RiverClient {

    private final ManagedChannel channel;
    private final RiverLevelServiceGrpc.RiverLevelServiceBlockingStub blockingStub;
    private final RiverLevelServiceGrpc.RiverLevelServiceStub asyncStub;

    public RiverClient() {
        channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        blockingStub = RiverLevelServiceGrpc.newBlockingStub(channel);
        asyncStub = RiverLevelServiceGrpc.newStub(channel);
    }

    // 1. Simple RPC
    public RiverResponse getCurrentRiverLevel(String location, String sensorId) {
        RiverRequest request = RiverRequest.newBuilder()
                .setLocation(location)
                .setSensorId(sensorId)
                .build();

        return blockingStub.getCurrentRiverLevel(request);
    }

    // 2. Client streaming RPC
    public void uploadRainfallData(String location, int days,
                                   StreamObserver<RainfallAnalysis> responseObserver) {

        StreamObserver<RainfallData> requestObserver = asyncStub.uploadRainfallData(responseObserver);

        Random rand = new Random();

        for (int i = 0; i < days; i++) {
            double chuva = 5 + rand.nextDouble() * 20; // 5 to 25 mm
            RainfallData data = RainfallData.newBuilder()
                    .setLocation(location) 
                    .setRainfallAmount(chuva)
                    .setTimestamp(Instant.now().toString())
                    .build();
            requestObserver.onNext(data);
        }

        requestObserver.onCompleted();
    }
    
    // 3.Bidirectional streaming RPC
    public void monitorRiverLevelLive(String location, String sensorId, int times,
                                      StreamObserver<RiverResponse> responseObserver) {
        // open the bidirectional stream
        StreamObserver<RiverRequest> requestObserver = asyncStub.monitorRiverLevelLive(responseObserver);

        try {
            for (int i = 0; i < times; i++) {
                RiverRequest request = RiverRequest.newBuilder()
                    .setLocation(location)
                    .setSensorId(sensorId)
                    .build(); // build request

                requestObserver.onNext(request);
                Thread.sleep(2000); // time of sensor reading every (2 seconds
            }

            requestObserver.onCompleted();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        channel.shutdown();
    }
}