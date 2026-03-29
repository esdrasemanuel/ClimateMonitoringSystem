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
        // 
        double temperature = -10 + 60 * random.nextDouble();
        double humidity = 40 + random.nextDouble() * 50;
        double pressure = 980 + random.nextDouble() * 40;
        double windSpeed = 5 + random.nextDouble() * 50;
        try {
            while (!serverObserver.isCancelled()) {
            
                // small changes
                temperature += (random.nextDouble() - 0.5) * 0.8; 
                humidity += (random.nextDouble() - 0.5) * 2.0;      
                pressure += (random.nextDouble() - 0.5) * 1.5;      
                windSpeed += (random.nextDouble() - 0.5) * 2.0;     

                // realistic limits
                temperature = Math.max(10, Math.min(35, temperature));
                humidity = Math.max(30, Math.min(100, humidity));
                pressure = Math.max(970, Math.min(1040, pressure));
                windSpeed = Math.max(0, Math.min(80, windSpeed));

                ClimateResponse response = ClimateResponse.newBuilder()
                        .setTemperature(temperature)
                        .setHumidity(humidity)
                        .setPressure(pressure)
                        .setWindSpeed(windSpeed)
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