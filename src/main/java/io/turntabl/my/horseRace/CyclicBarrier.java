package io.turntabl.my.horseRace;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

public class CyclicBarrier<barrier> extends Thread {
    private java.util.concurrent.CyclicBarrier barrier;

    public CyclicBarrier(int i, java.util.concurrent.CyclicBarrier barrier){
        super("cyclic-" + i);
        this.barrier = barrier;
    }
    public void run(){
        try{
            System.out.println("thread " + Thread.currentThread().getName() + " ready");
            barrier.await();
            Thread.sleep((int)(Math.random() * 10000));
            System.out.println("thread " + Thread.currentThread().getName() + " won");
            barrier.await();
        }
        catch(InterruptedException | BrokenBarrierException ie){}
    }
}
