package com.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch
 *
 * @author liuruizhi
 * @since 2017/11/24
 */
public class CountDownLatchTest {


    public static void main(String[] args) {
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
        countDownLatchTest.create();

    }

    private void create() {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executor.execute(new CounterRunner(countDownLatch));
        }
        try {
            countDownLatch.await();
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        System.out.println("main end");
    }

    private class CounterRunner implements Runnable {

        private CountDownLatch countDownLatch;

        CounterRunner(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread());
                Thread.sleep(3000L);
                System.out.println(Thread.currentThread() + "end");
            } catch (Exception e) {

            } finally {
                countDownLatch.countDown();
            }
        }
    }
}
