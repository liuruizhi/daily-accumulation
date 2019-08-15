/*
 * Copyright (c) 2019.
 */

package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

/**
 *
 * 该方案使用redis的Keyspace Notifications，中文翻译就是键空间机制，就是利用该机制可以在key失效之后，提供一个回调，实际上是redis会给客户端发送一个消息。是需要redis版本2.8以上。
 * 在redis.conf中，加入一条配置
 * notify-keyspace-events Ex
 *
 * @author liuruizhi
 * @since 2019/8/14
 */
public class RedisTest {
    private static final String ADDR = "127.0.0.1";
    private static final int PORT = 6379;
    private static JedisPool jedis = new JedisPool(ADDR, PORT);
    private static RedisSub sub = new RedisSub();

    public static void init() {
        new Thread(new Runnable() {
            public void run() {
                jedis.getResource().subscribe(sub, "__keyevent@0__:expired");
            }
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        init();
        for(int i =0;i<10;i++){
            String orderId = "OID000000"+i;
            Jedis jedisP = jedis.getResource();
            jedisP.setex(orderId, 3, orderId);
            System.out.println(System.currentTimeMillis()+"ms:"+orderId+"订单生成");
            // 如果此处不close，则只能生成7条记录，maxTotal = 8
            // jedisP.close();
        }
    }

    static class RedisSub extends JedisPubSub {
        @Override
        public void onMessage(String channel, String message) {
            System.out.println(System.currentTimeMillis()+"ms:"+message+"订单取消");
        }

//        @Override
//        public void onSubscribe(String channel, int subscribedChannels) {
//            System.out.println("订阅");
//        }
    }
}
