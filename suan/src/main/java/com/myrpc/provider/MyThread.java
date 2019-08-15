/*
 * Copyright (c) 2019.
 */

package com.myrpc.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.List;

/**
 * @author liuruizhi
 * @since 2019/8/14
 */
public class MyThread implements Runnable {

    private Socket client;
    private List<Object> serviceList;

    public MyThread(Socket client, List<Object> services) {
        this.client = client;
        this.serviceList = services;
    }

    @Override
    public void run() {
        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        try {

//            input = new ObjectInputStream(client.getInputStream());
//            String serviceName = input.readUTF();
//            String methodName = input.readUTF();
//            Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
//            Object[] arguments = (Object[]) input.readObject();
//
//            Class serviceClass = HelloServiceImpl.class;
//            if (serviceClass == null) {
//                throw new ClassNotFoundException(serviceName + " not found");
//            }
//            Method method = serviceClass.getMethod(methodName, parameterTypes);
//            Object result = method.invoke(serviceClass.newInstance(), arguments);
//            // 3.将执行结果反序列化，通过socket发送给客户端
//            output = new ObjectOutputStream(client.getOutputStream());
//            output.writeObject(result);
//            output.flush();

            input = new ObjectInputStream(client.getInputStream());
            output = new ObjectOutputStream(client.getOutputStream());
            Class serviceClass = (Class) input.readObject();
            Object service = findService(serviceClass);
            if (service == null) {
                output.writeObject("服务未找到.");
            } else {
                String methodName = input.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                Object[] arguments = (Object[]) input.readObject();
                Method method = service.getClass().getMethod(methodName, parameterTypes);
                Object result = method.invoke(service, arguments);
                output.writeObject(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                input.close();
                output.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private Object findService(Class clazz) {
        for (Object obj : serviceList) {

            if (clazz.isAssignableFrom(obj.getClass())) {
                return obj;
            }
        }
        return null;
    }
}
