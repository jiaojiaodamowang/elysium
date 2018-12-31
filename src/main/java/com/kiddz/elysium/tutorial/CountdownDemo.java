package com.kiddz.elysium.tutorial;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownDemo {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    private static CountDownLatch startSignal = new CountDownLatch(1);

    private static CountDownLatch stopSignal = new CountDownLatch(10);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String name = "worker-" + i;
            executor.execute(new Worker(name, startSignal, stopSignal));
        }
        executor.shutdown();
        // all threads get ready
        System.out.println("----------start------------");
        startSignal.countDown();
        // wait for all threads get done
        try {
            stopSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----------finished----------");
    }
}

class Worker implements Runnable {

    private String name;

    private CountDownLatch startSignal;

    private CountDownLatch stopSignal;

    Worker(String name, CountDownLatch startSignal, CountDownLatch stopSignal) {
        this.startSignal = startSignal;
        this.stopSignal = stopSignal;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            startSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " is running");
        stopSignal.countDown();
    }
}