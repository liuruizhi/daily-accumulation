package com.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test3 {

    private static Integer count = 0;

    final BlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        new Thread(test3.new Producer(), "producer").start();
        new Thread(test3.new Consumer(), "consumer").start();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i< 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    blockingDeque.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i< 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    blockingDeque.take();
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
