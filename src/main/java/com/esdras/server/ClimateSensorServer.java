/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esdras.server;

/**
 *
 * @author EMoreira
 */

import io.grpc.Server;
import io.grpc.ServerBuilder;

// test server
public class ClimateSensorServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                .addService(new ClimateSensorServiceImpl())
                .build();

        server.start(); 
        System.out.println("ClimateSensorService started on port 50051");
        server.awaitTermination();
    }
}
