package io.turntabl.my;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Collection {
   // private static String threadName;
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = IntStream.range(0, 10).mapToObj(i -> new Thread (() -> {
                    while (!Thread.interrupted()) { }
                    System.out.println("Thread " + i + " has been Interrupted");
                    //System.out.println("Thread " + threadName + " Interrupted");
                }))
                .collect(Collectors.toList());
        System.out.println(threads.size());
        threads.forEach(Thread::start);

        System.out.println("Active running threads: " + Thread.activeCount());
        Random random = new Random();
        while (Thread.activeCount() != 1){
            Thread.sleep(1000);
            threads.get(random.nextInt(10)).interrupt();
        }
    }
}
