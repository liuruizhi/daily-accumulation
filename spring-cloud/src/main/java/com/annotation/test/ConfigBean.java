package com.annotation.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuruizhi
 * @since 2019/9/5
 */
@Configuration
public class ConfigBean {

    @Bean
    public ServiceA serviceA() {
        return new ServiceA();
    }
}
