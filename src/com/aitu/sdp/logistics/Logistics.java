package com.aitu.sdp.logistics;

public abstract class Logistics {

    protected abstract Transport createTransport();

    public void planDelivery(String cargo, String destination) {
        System.out.println("Logistics: planning delivery of " + cargo + " to " + destination + ".");
        Transport transport = createTransport();
        transport.deliver(cargo, destination);
        System.out.println("Logistics: delivery planned.");
    }
}
