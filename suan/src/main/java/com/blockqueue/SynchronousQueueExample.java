/*
 * Copyright (c) 2019.
 */

package com.blockqueue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author liuruizhi
 * @since 2019/8/6
 */
public class SynchronousQueueExample {

    static final BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();

    static class SynchronousQueueProducer implements Runnable {

        protected BlockingQueue<String> blockingQueue;
        final Random random = new Random();

        public SynchronousQueueProducer(BlockingQueue<String> queue) {
            this.blockingQueue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String data = UUID.randomUUID().toString();
                    System.out.println("Put: " + data);
                    blockingQueue.put(data);
//                    Thread.sleep(1000);
                    System.out.println("put end.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static class SynchronousQueueConsumer implements Runnable {

        protected BlockingQueue<String> blockingQueue;

        public SynchronousQueueConsumer(BlockingQueue<String> queue) {
            this.blockingQueue = queue;
        }

        @Override
        public void run() {
//            while (true) {
                try {
                    String data = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName()
                            + " take(): " + data);
//                    Thread.sleep(2000);
                    System.out.println("take end.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
        }

    }

    public static void main(String[] args) {


        SynchronousQueueConsumer queueConsumer1 = new SynchronousQueueConsumer(
                synchronousQueue);
        new Thread(queueConsumer1).start();

//        SynchronousQueueConsumer queueConsumer2 = new SynchronousQueueConsumer(
//                synchronousQueue);
//        new Thread(queueConsumer2).start();

    }
}
