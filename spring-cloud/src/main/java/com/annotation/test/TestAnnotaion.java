package com.annotation.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * public AnnotationConfigApplicationContext(Class<?>... annotatedClasses) {
 * //调用无参构造函数
 * this();
 * //注册含有注解的类
 * register(annotatedClasses);
 * //刷新应用程序上下文
 * refresh();
 * }
 *
 *
 * @author liuruizhi
 * @since 2019/9/5
 */
@Configuration//(1)
@ComponentScan(basePackages = "com.annotation.test") // (2)
@Import(com.annotation.test.ConfigBean2.class) // (3)
@PropertySource(value={"classpath:config.properties"})//(4)
public class TestAnnotaion {

    public static void main(String[] args) {

        // (5)
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TestAnnotaion.class);
        ctx.getBean("serviceB", ServiceB.class).sayHello();// (6)
    }
}
