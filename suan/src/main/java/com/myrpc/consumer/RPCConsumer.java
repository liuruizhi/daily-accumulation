/*
 * Copyright (c) 2019.
 */

package com.myrpc.consumer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author liuruizhi
 * @since 2019/8/14
 */
public class RPCConsumer {

    public static <T> T getService(final Class<?> clazz, String ip, int port) {
        ProxyHandler proxyHandler = new ProxyHandler(ip, port);
        return (T) Proxy.newProxyInstance(RPCConsumer.class.getClassLoader(), new Class<?>[]{clazz}, proxyHandler);
//        return (T) Proxy.newProxyInstance(RPCConsumer.class.getClassLoader(), new Class<?>[]{clazz}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                Socket socket = null;
//                ObjectOutputStream output = null;
//                ObjectInputStream input = null;
//                try {
//                    // 1.创建Socket客户端，根据指定地址连接远程服务提供者
//                    socket = new Socket("localhost", 20006);
////                    socket.connect(addr);
//
//                    // 2.将远程服务调用所需的接口类、方法名、参数列表等编码后发送给服务提供者
//                    output = new ObjectOutputStream(socket.getOutputStream());
//                    output.writeUTF(clazz.getName());
//                    output.writeUTF(method.getName());
//                    output.writeObject(method.getParameterTypes());
//                    output.writeObject(args);
//                    output.flush();
//
//                    // 3.同步阻塞等待服务器返回应答，获取应答后返回
//                    input = new ObjectInputStream(socket.getInputStream());
//                    Object obj = input.readObject();
//
//                    return obj;
//                } finally {
//                    if (socket != null) socket.close();
//                    if (output != null) output.close();
//                    if (input != null) input.close();
//                }
//            }
//
//        });
    }
}
