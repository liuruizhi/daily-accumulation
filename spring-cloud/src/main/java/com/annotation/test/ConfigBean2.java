package com.annotation.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuruizhi
 * @since 2019/9/5
 */
@Configuration
public class ConfigBean2 {

    @Bean
    public ServiceB serviceB() {
        return new ServiceB();
    }
}
