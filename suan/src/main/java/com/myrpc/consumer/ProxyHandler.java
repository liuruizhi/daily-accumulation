/*
 * Copyright (c) 2019.
 */

package com.myrpc.consumer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author liuruizhi
 * @since 2019/8/14
 */
public class ProxyHandler implements InvocationHandler {

    private String ip;
    private int port;

    public ProxyHandler(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Socket socket = new Socket(this.ip, this.port);
        socket.setSoTimeout(10000);
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

        try {
            output.writeObject(proxy.getClass().getInterfaces()[0]);
            output.writeUTF(method.getName());
            output.writeObject(method.getParameterTypes());
            output.writeObject(args);
            output.flush();
            Object result = input.readObject();
            if(result instanceof Throwable) {
                throw (Throwable) result;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
            output.close();
            input.close();
        }
        return null;
    }
}
