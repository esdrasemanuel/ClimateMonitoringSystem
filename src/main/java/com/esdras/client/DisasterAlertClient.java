/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esdras.client;

import com.esdras.alert.*;
import com.esdras.naming.ServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import javax.jmdns.ServiceInfo;
/**
 *
 * @author EMoreira
 */

public class DisasterAlertClient {

    private ManagedChannel channel;
    private DisasterAlertServiceGrpc.DisasterAlertServiceBlockingStub blockingStub;
    private DisasterAlertServiceGrpc.DisasterAlertServiceStub asyncStub;
    private StreamObserver<LiveAlertRequest> liveAlertObserver;
    private int portNumber;
    
    public DisasterAlertClient() throws IOException, InterruptedException {
        discoverAndConnect();
    }
    
    private void discoverAndConnect() throws IOException, InterruptedException {
        ServiceDiscovery serviceDiscovery = new ServiceDiscovery("_grpc._tcp.local.", "DisasterAlertService");

        try {
            ServiceInfo serviceInfo = serviceDiscovery.discoverService(5000);
            System.out.print("Discovered service: ");
            System.out.println("Port number: " + serviceInfo.getPort() + " " + serviceInfo.getName());
            portNumber = serviceInfo.getPort();
            serviceDiscovery.close();
        } catch (Exception e) {
            e.printStackTrace();
            serviceDiscovery.close();
            throw new RuntimeException("DisasterAlertService not found on the network.");
        }

        channel = ManagedChannelBuilder
                .forAddress("localhost", portNumber)
                .usePlaintext()
                .build();

        blockingStub = DisasterAlertServiceGrpc.newBlockingStub(channel);
        asyncStub    = DisasterAlertServiceGrpc.newStub(channel);
    }

    public AlertResponse generateStormAlert(String location, double temperature, double humidity,
                                            double windSpeed, double pressure, String timestamp) {

        AlertRequest request = AlertRequest.newBuilder()
                .setLocation(location)
                .setTemperature(temperature)
                .setHumidity(humidity)
                .setWindSpeed(windSpeed)
                .setPressure(pressure)
                .setTimestamp(timestamp)
                .build();

        return blockingStub.generateStormAlert(request);
    }
    
    // Start bidi
    public void startLiveAlertFeed(StreamObserver<AlertResponse> responseObserver) {
        liveAlertObserver = asyncStub.streamLiveAlerts(responseObserver);
    }

    // Send live combined data
    public void sendLiveAlertData(double temperature, double humidity,
                                  double windSpeed, double pressure, double riverLevel, String timestamp) {

        if (liveAlertObserver != null) {
            LiveAlertRequest request = LiveAlertRequest.newBuilder()
                    .setTemperature(temperature)
                    .setHumidity(humidity)
                    .setWindSpeed(windSpeed)
                    .setPressure(pressure)
                    .setRiverLevel(riverLevel)
                    .setTimestamp(timestamp)
                    .build();

            liveAlertObserver.onNext(request);
        }
    }

    // Stop bidi
    public void stopLiveAlertFeed() {
        if (liveAlertObserver != null) {
            liveAlertObserver.onCompleted();
        }
    }

    public void shutdown() {
        channel.shutdown();
    }
}

