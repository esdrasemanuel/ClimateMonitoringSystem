/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esdras.server;
import com.esdras.alert.*;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Iterator;
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

    // 2. Server streaming
    @Override
    public void streamActiveAlerts(AlertStreamRequest request, StreamObserver<AlertResponse> responseObserver) {

        ServerCallStreamObserver<AlertResponse> serverObserver =
                (ServerCallStreamObserver<AlertResponse>) responseObserver;

        try {
            while (!serverObserver.isCancelled()) {
                
                // If there is no current alert or the replay has ended it generates a new one (to looks more real).
                if (currentAlert == null || repetition == 0) {
                    currentAlert = generateRandomAlert();
                }
                responseObserver.onNext(
                        AlertResponse.newBuilder()
                            .setAlertType(currentAlert.getAlertType())
                            .setSeverityLevel(currentAlert.getSeverityLevel())
                            .setMessage(currentAlert.getMessage())
                            .setTimestamp(LocalDateTime.now().toString())
                            .build()
                );
                repetition--;
                
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AlertResponse generateRandomAlert() {

        String alertType;
        String severityLevel;
        String message;
       
        int option = random.nextInt(4);

        switch (option) {
            case 0:
                alertType = "Storm Warning";
                severityLevel = "High";
                message = "Severe storm conditions detected.";
                break;
            case 1:
                alertType = "Heavy Rain Warning";
                severityLevel = "Medium";
                message = "Persistent heavy rainfall expected.";
                break;
            case 2:
                alertType = "Heat Alert";
                severityLevel = "Medium";
                message = "High temperatures detected in the monitored area.";
                break;
            default:
                alertType = "No Active Alert";
                severityLevel = "Low";
                message = "No immediate environmental risks detected.";
                break;
        }
        
        repetition = 3 + random.nextInt(8);

        return AlertResponse.newBuilder()
                .setAlertType(alertType)
                .setSeverityLevel(severityLevel)
                .setMessage(message)
                .setTimestamp(LocalDateTime.now().toString())
                .build();
    }
}
