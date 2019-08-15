/*
 * Copyright (c) 2019.
 */

package com.myrpc.provider;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuruizhi
 * @since 2019/8/14
 */
public class RPCProvider {

    private static List<Object> serviceList;

    public static void export(int port, Object... service) throws Exception {
        serviceList = Arrays.asList(service);

        ServerSocket serverSocket = new ServerSocket(port);
        Socket client = null;

        while (true) {
            client = serverSocket.accept();
            // 每一个请求启动一个线程处理
            new Thread(new MyThread(client, serviceList)).start();
        }
    }
}
