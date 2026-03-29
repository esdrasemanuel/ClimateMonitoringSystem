/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esdras.server;
import com.esdras.climate.*;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * @author EMoreira
 */

public class ClimateSensorServiceImpl extends ClimateSensorServiceGrpc.ClimateSensorServiceImplBase {

    private final Random random = new Random();

    @Override
    public void getCurrentClimateData(ClimateRequest request, StreamObserver<ClimateResponse> responseObserver) {
        ClimateResponse response = ClimateResponse.newBuilder()
                .setTemperature(-10 + 60 * random.nextDouble()) // -10 a 50 °C
                .setHumidity(40 + random.nextDouble() * 50)
                .setPressure(980 + random.nextDouble() * 40)
                .setWindSpeed(5 + random.nextDouble() * 50)
                .setTimestamp(LocalDateTime.now().toString())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void streamLiveClimateData(ClimateRequest request, StreamObserver<ClimateResponse> responseObserver) {
        ServerCallStreamObserver<ClimateResponse> serverObserver =
            (ServerCallStreamObserver<ClimateResponse>) responseObserver;
        try {
            while (!serverObserver.isCancelled()) {
                ClimateResponse response = ClimateResponse.newBuilder()
                        .setTemperature(-10 + 60 * random.nextDouble())
                        .setHumidity(40 + random.nextDouble() * 50)
                        .setPressure(980 + random.nextDouble() * 40)
                        .setWindSpeed(5 + random.nextDouble() * 50)
                        .setTimestamp(LocalDateTime.now().toString())
                        .build();

                responseObserver.onNext(response);
                Thread.sleep(2000);
                
                 System.out.println("Client disconnected.");
            }
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        responseObserver.onCompleted();
    }
}