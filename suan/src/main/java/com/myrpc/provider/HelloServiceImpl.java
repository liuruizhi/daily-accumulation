/*
 * Copyright (c) 2019.
 */

package com.myrpc.provider;

import com.myrpc.HelloService;

/**
 * @author liuruizhi
 * @since 2019/8/14
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello world.";
    }
}
