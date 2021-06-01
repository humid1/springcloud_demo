package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author qiujianping
 * @date Created in 2021/6/1 17:57
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication3355.class, args);
    }
}
