/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esdras.server;
import com.esdras.alert.*;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Random;
/**
 *
 * @author EMoreira
 */

public class DisasterAlertServiceImpl extends DisasterAlertServiceGrpc.DisasterAlertServiceImplBase {

    private final Random random = new Random();
    private int repetition = 0;
    private AlertResponse currentAlert;

    // 1. Simple RPC
    @Override
    public void generateStormAlert(AlertRequest request, StreamObserver<AlertResponse> responseObserver) {

        String alertType = "";
        String severityLevel = "";
        String message = "";

        if (request.getWindSpeed() > 35 && request.getPressure() < 1000 && request.getHumidity() > 80) {
            alertType = "Storm Warning";
            severityLevel = "High";
            message = "High probability of severe storm conditions.";
        } else if (request.getWindSpeed() > 25 && request.getHumidity() > 70) {
            alertType = "Heavy Rain Warning";
            severityLevel = "Medium";
            message = "Potential heavy rainfall and unstable weather conditions.";
        } else if (request.getWindSpeed() > 40 && request.getPressure() < 1000 && request.getHumidity() > 85) {
            alertType = "Storm Alert";
            severityLevel = "Very High";
            message = "Severe storm conditions with strongs winds";
        }else {
            alertType = "No Active Alert";
            severityLevel = "Low";
            message = "Weather conditions are stable.";
        }

        AlertResponse response = AlertResponse.newBuilder()
                .setAlertType(alertType)
                .setSeverityLevel(severityLevel)
                .setMessage(message)
                .setTimestamp(LocalDateTime.now().toString())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    // 2. Bidirectional Streaming RPC
    @Override
    public StreamObserver<LiveAlertRequest> streamLiveAlerts(StreamObserver<AlertResponse> responseObserver) {

        ServerCallStreamObserver<AlertResponse> serverObserver =
                (ServerCallStreamObserver<AlertResponse>) responseObserver;

        return new StreamObserver<LiveAlertRequest>() {

            @Override
            public void onNext(LiveAlertRequest request) {
                if (!serverObserver.isCancelled()) {

                    String alertType = "";
                    String severityLevel = "";
                    String message = "";

                    double windSpeed = request.getWindSpeed();
                    double pressure = request.getPressure();
                    double humidity = request.getHumidity();
                    double riverLevel = request.getRiverLevel();

                    // lógica combinando climate + river
                    if (riverLevel > 4.5 && windSpeed > 35 && pressure < 1000 && humidity > 80) {
                        alertType = "Severe Flood Storm Alert";
                        severityLevel = "Very High";
                        message = "Critical flood and storm conditions detected.";
                    } else if (riverLevel > 3.5 && humidity > 75 && windSpeed > 25) {
                        alertType = "Flood Risk Warning";
                        severityLevel = "High";
                        message = "River level rising with unstable weather conditions.";
                    } else if (windSpeed > 35 && pressure < 1000 && humidity > 80) {
                        alertType = "Storm Warning";
                        severityLevel = "High";
                        message = "High probability of severe storm conditions.";
                    } else if (windSpeed > 25 && humidity > 70) {
                        alertType = "Heavy Rain Warning";
                        severityLevel = "Medium";
                        message = "Potential heavy rainfall and unstable weather conditions.";
                    } else if (riverLevel > 3.0) {
                        alertType = "River Level Alert";
                        severityLevel = "Medium";
                        message = "River level above normal threshold.";
                    } else {
                        alertType = "No Active Alert";
                        severityLevel = "Low";
                        message = "No immediate environmental risks detected.";
                    }

                    AlertResponse response = AlertResponse.newBuilder()
                            .setAlertType(alertType)
                            .setSeverityLevel(severityLevel)
                            .setMessage(message)
                            .setTimestamp(LocalDateTime.now().toString())
                            .build();

                    responseObserver.onNext(response);
                }
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Live alert stream error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Live alert monitoring ended.");
                responseObserver.onCompleted();
            }
        };
    }
}
