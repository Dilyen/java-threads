package io.turntabl.my;

//import java.util.stream.IntStream;
public class MyThread {
    private Thread t;
    private String threadName;

    MyThread(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running  " + threadName);
        try {
            for (int i = 4; 1 > 0; i--) {
                System.out.println("Thread: " + threadName + "," + i);
                //Let the thread sleep for Then seconds
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread: " + threadName + "interrupted");
        }
        start(); {
            System.out.println("Starting " + threadName);
            if (t == null) {
                t = new Thread(this.threadName);
                t.start();
            }
        }
    }

    public static class TestThread {
        public static void main(String args[]) throws InterruptedException {
            //Let the thread sleep for Then seconds
            Thread.sleep(10000);
            MyThread T1 = new MyThread("Thread 1");
            T1.start();

            MyThread T2 = new MyThread("Thread 2");
            T2.start();

            Thread t = new Thread (() ->
                    System.out.print("."));
            t.start();
            System.out.println("main thread end successfully........... ");

            t.join();

        }

    }

    public void start() {
        System.out.println("Starting " + threadName );
        if (t == null){
            t = new Thread (this.threadName);
            t.start();
        }


    }
}