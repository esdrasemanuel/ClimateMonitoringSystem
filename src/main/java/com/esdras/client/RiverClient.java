/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esdras.client;
import com.esdras.river.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author EMoreira
 */

public class RiverClient {

    private final ManagedChannel channel;
    private final RiverLevelServiceGrpc.RiverLevelServiceBlockingStub blockingStub;
    private final RiverLevelServiceGrpc.RiverLevelServiceStub asyncStub;
    private StreamObserver<RiverRequestBidi> liveStreamObserver;
    private Timer timer;

    public RiverClient() {
        channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        blockingStub = RiverLevelServiceGrpc.newBlockingStub(channel);
        asyncStub = RiverLevelServiceGrpc.newStub(channel);
    }

    // 1. Simple RPC
    public RiverResponse getCurrentRiverLevel(String location) {
        RiverRequest request = RiverRequest.newBuilder()
                .setLocation(location)
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
                    .build();
            requestObserver.onNext(data);
        }

        requestObserver.onCompleted();
    }
    
    // 3.Bidirectional streaming RPC
    public void startLiveMonitoring(String location, StreamObserver<RiverResponse> responseObserver) {
        liveStreamObserver = asyncStub.monitorRiverLevelLive(responseObserver);

        timer = new Timer(2000, e -> { //  2 sec
            double simulatedLevel = 2.0 + new Random().nextDouble() * 3.0; // simulates 2.0 to 5.0 metres
            RiverRequestBidi request = RiverRequestBidi.newBuilder()
                    .setLocation(location)
                    .setRiverLevel(simulatedLevel)
                    .build();
            liveStreamObserver.onNext(request);
        });

        timer.start();
    }

    public void stopLiveMonitoring() {
        if (timer != null) timer.stop();
        if (liveStreamObserver != null) liveStreamObserver.onCompleted();
    }

    public void shutdown() {
        channel.shutdown();
    }
}