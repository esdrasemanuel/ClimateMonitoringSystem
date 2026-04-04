/**
 *
 * @author EMoreira
 */

package com.esdras.naming;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

/**
 * ServiceRegistration
 * Registers gRPC services with JmDNS so clients can discover them.
 * Uses the Singleton pattern - only one JmDNS instance is created.
 */
public class ServiceRegistration {

    private static JmDNS jmdns;
    private static ServiceRegistration theRegister;

    private ServiceRegistration() throws UnknownHostException, IOException {
        jmdns = JmDNS.create(InetAddress.getLocalHost());
        System.out.println("Register: InetAddress.getLocalHost(): " + InetAddress.getLocalHost());
    }

    public static ServiceRegistration getInstance() throws IOException {
        if (theRegister == null) {
            theRegister = new ServiceRegistration();
        }
        return theRegister;
    }

    public void registerService(String type, String name, int port, String text) throws IOException {
        ServiceInfo serviceInfo = ServiceInfo.create(type, name, port, text);
        jmdns.registerService(serviceInfo);
        System.out.println("Registered Service: " + serviceInfo.toString());
    }
}
