package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author qiujianping
 * @date Created in 2021/6/2 15:06
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication3356 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication3356.class, args);
    }
}
