/*
 * Copyright (c) 2019.
 */

package com.blockqueue;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuruizhi
 * @since 2019/8/6
 */
public class Producer {

    public static void main(String[] args) throws Exception {
//        SynchronousQueueExample.SynchronousQueueProducer queueProducer = new SynchronousQueueExample.SynchronousQueueProducer(
//                SynchronousQueueExample.synchronousQueue);
//        new Thread(queueProducer).start();


//        ExecutorService executorService = new ThreadPoolExecutor(1, 1,
//                60L, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<Runnable>(10));
//
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("abcdefg");
//            }
//        });
//
//        executorService.shutdown();

//        MessageDigest md = MessageDigest.getInstance("MD5");
//        md.update("sdfd".getBytes("utf-8"));
//        String password = new BigInteger(1, md.digest()).toString(16);
//        System.out.println(password);

        System.out.println("unifiedLogout".contains("login"));
    }
}
