/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esdras.client;
import com.esdras.alert.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
/**
 *
 * @author EMoreira
 */

public class DisasterAlertClient {

    private final ManagedChannel channel;
    private final DisasterAlertServiceGrpc.DisasterAlertServiceBlockingStub blockingStub;
    private final DisasterAlertServiceGrpc.DisasterAlertServiceStub asyncStub;

    public DisasterAlertClient() {
        channel = ManagedChannelBuilder
                .forAddress("localhost", 50053)
                .usePlaintext()
                .build();

        blockingStub = DisasterAlertServiceGrpc.newBlockingStub(channel);
        asyncStub = DisasterAlertServiceGrpc.newStub(channel);
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

    public void streamActiveAlerts(String location, StreamObserver<AlertResponse> responseObserver) {

        AlertStreamRequest request = AlertStreamRequest.newBuilder()
                .setLocation(location)
                .build();

        asyncStub.streamActiveAlerts(request, responseObserver);
    }

    public void shutdown() {
        channel.shutdown();
    }
}

