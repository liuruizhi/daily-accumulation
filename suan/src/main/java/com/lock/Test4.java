package com.lock;

import java.util.concurrent.Semaphore;

public class Test4 {

    private static Integer count = 0;
    private final Semaphore notFull = new Semaphore(1);
    private final Semaphore notEmpty = new Semaphore(0); // 设置为0防止提前消费
    private final Semaphore mutex = new Semaphore(1);

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        new Thread(test4.new Producer(), "producer").start();
        new Thread(test4.new Consumer(), "consumer").start();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    notFull.acquire();
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName() + "count " + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notEmpty.release();
                }

            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    notEmpty.acquire();
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName() + "count " + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notFull.release();
                }
            }
        }
    }
}
