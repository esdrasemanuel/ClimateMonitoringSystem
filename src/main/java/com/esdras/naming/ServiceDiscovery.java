/**
 *
 * @author EMoreira
 */

package com.esdras.naming;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

/**
 * ServiceDiscovery
 * Discovers a gRPC service by type and name using JmDNS.
 * Uses a CountDownLatch to wait until the service is resolved or timeout occurs.
 */
public class ServiceDiscovery {

    private final String requiredServiceType;
    private final String requiredServiceName;
    private ServiceInfo foundService;
    private JmDNS jmdns;

    public ServiceDiscovery(String inServiceType, String inServiceName) {
        requiredServiceType = inServiceType;
        requiredServiceName = inServiceName;
    }

    public ServiceInfo discoverService(long timeoutMilliseconds) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            System.out.println("Client: InetAddress.getLocalHost(): " + InetAddress.getLocalHost());

            jmdns.addServiceListener(requiredServiceType, new ServiceListener() {

                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Service adde: " + event.getInfo());
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Service removed: " + event.getInfo());
                }

                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Service resolved: " + event.getInfo());
                    ServiceInfo serviceInfo = event.getInfo();
                    int port = serviceInfo.getPort();
                    String resolvedServiceName = serviceInfo.getName();

                    System.out.println("# service " + resolvedServiceName + " resolved at port: " + port);

                    if (resolvedServiceName.equals(requiredServiceName)) {
                        foundService = serviceInfo;
                        latch.countDown();
                    }
                }
            });

        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        latch.await(timeoutMilliseconds, TimeUnit.MILLISECONDS);
        System.out.println("Discover Service returning: " + foundService);
        return foundService;
    }

    public void close() throws IOException {
        if (jmdns != null) {
            jmdns.close();
        }
    }
}
