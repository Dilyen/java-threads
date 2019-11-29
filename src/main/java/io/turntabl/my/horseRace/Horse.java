package io.turntabl.my.horseRace;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;



public class Horse implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;

    Horse(CyclicBarrier b) {
        barrier = b;

    }
    synchronized int getStrides() {
        return strides;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Thread " + id + ",");
                    strides += rand.nextInt(3);
                    barrier.await();
                }
        } catch (InterruptedException | BrokenBarrierException ignored) {
        }
    }
    public String toString() {
        return "Horse " + id + " ";
    }
    String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < getStrides(); i++)
            s.append("*");
        s.append(id);
        return s.toString();
    }
}
