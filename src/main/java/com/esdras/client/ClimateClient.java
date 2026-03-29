/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esdras.client;
import com.esdras.climate.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;
/**
 *
 * @author EMoreira
 */

public class ClimateClient {

    private final ManagedChannel channel;
    private final ClimateSensorServiceGrpc.ClimateSensorServiceBlockingStub blockingStub;

    public ClimateClient() {
        channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        blockingStub = ClimateSensorServiceGrpc.newBlockingStub(channel);
    }

    // Simple RPC
    public ClimateResponse getCurrentClimateData(String location, String stationId) {
        ClimateRequest request = ClimateRequest.newBuilder()
                .setLocation(location)
                .setStationId(stationId)
                .build();

        return blockingStub.getCurrentClimateData(request);
    }

    // Server Streaming RPC
    public Iterator<ClimateResponse> streamLiveClimateData(String location, String stationId) {
        ClimateRequest request = ClimateRequest.newBuilder()
                .setLocation(location)
                .setStationId(stationId)
                .build();

        return blockingStub.streamLiveClimateData(request);
    }

    public void shutdown() {
        channel.shutdown();
    }
}