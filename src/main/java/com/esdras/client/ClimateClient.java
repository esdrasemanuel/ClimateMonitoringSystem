/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esdras.client;

import com.esdras.climate.*;
import com.esdras.naming.ServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientResponseObserver;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import javax.jmdns.ServiceInfo;


/**
 * @author EMoreira
 */
public class ClimateClient {

private ManagedChannel channel;
    private ClimateSensorServiceGrpc.ClimateSensorServiceBlockingStub blockingStub;
    private ClimateSensorServiceGrpc.ClimateSensorServiceStub asyncStub;
    private int portNumber;

    // Holds the reference to the active stream so we can cancel it
    private ClientCallStreamObserver<ClimateRequest> activeStreamObserver;

    public ClimateClient() throws IOException, InterruptedException{
        discoverAndConnect();
    }
    
    private void discoverAndConnect() throws IOException, InterruptedException {
        ServiceDiscovery serviceDiscovery = new ServiceDiscovery("_grpc._tcp.local.", "ClimateSensorService");

        try {
            ServiceInfo serviceInfo = serviceDiscovery.discoverService(5000);
            System.out.print("Discovered service: ");
            System.out.println("Port number: " + serviceInfo.getPort() + " " + serviceInfo.getName());
            portNumber = serviceInfo.getPort();
            serviceDiscovery.close();
        } catch (Exception e) {
            e.printStackTrace();
            serviceDiscovery.close();
            throw new RuntimeException("ClimateSensorService not found on the network.");
        }

        channel = ManagedChannelBuilder
                .forAddress("localhost", portNumber)
                .usePlaintext()
                .build();

        blockingStub = ClimateSensorServiceGrpc.newBlockingStub(channel);
        asyncStub    = ClimateSensorServiceGrpc.newStub(channel);
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
    // Uses ClientResponseObserver so we can grab the call reference and cancel it later.
    public void streamLiveClimateData(String location, String stationId,
                                      StreamObserver<ClimateResponse> responseObserver) {

        ClimateRequest request = ClimateRequest.newBuilder()
                .setLocation(location)
                .setStationId(stationId)
                .build();

        // using a observer so we can intercept beforeStart() and store the call reference
        asyncStub.streamLiveClimateData(request, new ClientResponseObserver<ClimateRequest, ClimateResponse>() {

            @Override
            public void beforeStart(ClientCallStreamObserver<ClimateRequest> requestStream) {
                // Save a reference to this specific stream call / used to stop the server response using the button stop live stream
                activeStreamObserver = requestStream;
            }

            @Override
            public void onNext(ClimateResponse value) {
                responseObserver.onNext(value);
            }

            @Override
            public void onError(Throwable t) {
                activeStreamObserver = null;
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                activeStreamObserver = null;
                responseObserver.onCompleted();
            }
        });
    }

    public void cancelStream() {
        if (activeStreamObserver != null) {
            activeStreamObserver.cancel("Cancelled by user", null);
            activeStreamObserver = null;
        }
    }

    public void shutdown() {
        cancelStream(); // cancel any active stream before shutting down
        if (channel != null && !channel.isShutdown()) {
            channel.shutdown();
        }
    }
}