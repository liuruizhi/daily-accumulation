package com.annotation.test;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author liuruizhi
 * @since 2019/9/5
 */
public class ServiceA {

    //这里加了一个注解
    @Value("${service.name}")
    private String serviceName;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void sayHello() {
        System.out.println("serviceA sayHello " + serviceName);

    }
}
