package com.esdras.client;
import com.esdras.climate.ClimateResponse;
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author EMoreira
 */
public class ClimateClientTest {

    public static void main(String[] args) {
        ClimateClient client = new ClimateClient();

        // TEST 1 - Simple RPC
        ClimateResponse response = client.getCurrentClimateData("Dublin", "Station-01");

        System.out.println("[CURRENT CLIMATE DATA]");
        System.out.println("Temperature: " + response.getTemperature());
        System.out.println("Humidity: " + response.getHumidity());
        System.out.println("Pressure: " + response.getPressure());
        System.out.println("Wind Speed: " + response.getWindSpeed());
        System.out.println("Timestamp: " + response.getTimestamp());

        // TEST 2 - Streaming RPC
        System.out.println("\n [LIVE CLIMATE STREAM]");

        Iterator<ClimateResponse> stream = client.streamLiveClimateData("Dublin", "Station-01");

        int count = 0;
        // test stream 5 times
        while (stream.hasNext() && count < 5) {
            ClimateResponse streamResponse = stream.next();

            System.out.println("---- Reading " + (count + 1) + " ----");
            System.out.println("Temperature: " + streamResponse.getTemperature());
            System.out.println("Humidity: " + streamResponse.getHumidity());
            System.out.println("Pressure: " + streamResponse.getPressure());
            System.out.println("Wind Speed: " + streamResponse.getWindSpeed());
            System.out.println("Timestamp: " + streamResponse.getTimestamp());

            count++;
        }

        client.shutdown();
    }
}