/*
 * Copyright (c) 2019.
 */

package com.myrpc.provider;

import com.myrpc.HelloService;

/**
 * @author liuruizhi
 * @since 2019/8/14
 */
public class RpcBootStrap {

    public static void main(String[] args) throws Exception {
        HelloService helloService =new HelloServiceImpl();
        //发布卖煎饼的服务，注册在20006端口
        RPCProvider.export(20006, helloService);
    }
}
