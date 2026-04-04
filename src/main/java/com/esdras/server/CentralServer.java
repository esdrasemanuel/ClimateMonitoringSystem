/**
 *
 * @author EMoreira
 */

package com.esdras.server;

import com.esdras.naming.ServiceRegistration;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * (CentralServer)
 * Starts all 3 gRPC services and registers each one with JmDNS
 * so clients can discover them by name on the local network
 */

public class CentralServer {

    private static final Logger logger = Logger.getLogger(CentralServer.class.getName());

    public static void main(String[] args) {

        int port = 50051;

        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(new ClimateSensorServiceImpl())
                    .addService(new RiverLevelServiceImpl())
                    .addService(new DisasterAlertServiceImpl())
                    .build()
                    .start();

            logger.info("Server started, listening on " + port);
            System.out.println("***** Server started, listening on port " + port);

            // Register each service with JmDNS so clients can discover them
            ServiceRegistration registration = ServiceRegistration.getInstance();
            registration.registerService("_grpc._tcp.local.", "ClimateSensorService", port, "Climate sensor data service");
            registration.registerService("_grpc._tcp.local.", "RiverLevelService",    port, "River level monitoring service");
            registration.registerService("_grpc._tcp.local.", "DisasterAlertService", port, "Disaster alert generation service");

            server.awaitTermination();

        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
}
