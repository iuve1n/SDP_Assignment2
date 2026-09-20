package com.aitu.sdp.logistics;

public class Ship implements Transport {

    @Override
    public void deliver(String cargo, String destination) {
        System.out.println("Ship: shipping " + cargo + " to " + destination + " by sea.");
    }
}
