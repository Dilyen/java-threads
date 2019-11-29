package io.turntabl.my;

import org.junit.Assert;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;

public class ProducerConsumer {
    private static Integer threadName;
    int[] ArrayQueue;
    int i;
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> ArrayQueue = new ArrayBlockingQueue<>(12);

        Thread producer_t1 = new Thread(()->
                IntStream.range(0, 12).forEach(i ->{
            ArrayQueue.offer(i);
            Thread.yield();
        }));

        Thread consumer_t2 = new Thread(()->
                IntStream.range(0, 12).forEach(i ->{
            System.out.println("Consumer: " + ArrayQueue.poll());
            Thread.yield();
        }));

        producer_t1.start();
        consumer_t2.start();

        producer_t1.join();
        consumer_t2.join();
    }
    @Test
    public void testOffer(){
        ArrayBlockingQueue<String> ArrayQueue = new ArrayBlockingQueue<>(1);
        Queue q = Collections.checkedQueue(ArrayQueue, String.class);

        try{
            q.offer(null);
            System.err.println("should throw NullPointException. ");
        }catch (NullPointerException npe){
            // Do nothing
        }
        try{
            q.offer(0);
            System.err.println("should throw ClassCastException. ");
        }catch (ClassCastException cce){
            // Do nothing
        }
        Assert.assertTrue("queue should have room", q.offer("0"));

        // no room in the inn
        Assert.assertFalse("queue should be full", q.offer("1"));



    }

}
