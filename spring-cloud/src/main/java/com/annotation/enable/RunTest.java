package com.annotation.enable;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuruizhi
 * @since 2019/9/6
 */
@EnableBean
@ComponentScan("com.annotaion.enable")
public class RunTest {
    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(RunTest.class, args);
        System.out.println(cac.getBean(User.class));
        System.out.println(cac.getBean(Role.class));
    }
}
