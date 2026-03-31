/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esdras.server;
import com.esdras.alert.*;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;

/**
 *
 * @author EMoreira
 */

public class DisasterAlertServiceImpl extends DisasterAlertServiceGrpc.DisasterAlertServiceImplBase {

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
}
