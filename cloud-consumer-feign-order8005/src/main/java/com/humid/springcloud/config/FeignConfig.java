package com.humid.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiujianping
 * @date Created in 2021/5/17 18:04
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLever() {
        return Logger.Level.FULL;
    }
}
