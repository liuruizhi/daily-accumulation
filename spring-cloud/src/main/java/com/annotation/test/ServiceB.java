package com.annotation.test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liuruizhi
 * @since 2019/9/5
 */
public class ServiceB {

    @Autowired
    private ServiceA serviceA;

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public void sayHello() {
        serviceA.sayHello();
    }
}
