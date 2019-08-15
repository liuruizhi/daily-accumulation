/*
 * Copyright (c) 2019.
 */

package com.myrpc.consumer;

import com.myrpc.HelloService;

/**
 * @author liuruizhi
 * @since 2019/8/14
 */
public class RpcTest {
    public static void main(String[] args) {
        HelloService helloService=RPCConsumer.getService(HelloService.class, "localhost", 20006);
        String result=helloService.sayHello("test");
        System.out.println(result);
    }
}
