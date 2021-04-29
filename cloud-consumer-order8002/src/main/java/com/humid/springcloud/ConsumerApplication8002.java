package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author qiujianping
 * @date Created in 2021/4/28 17:06
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication8002 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication8002.class, args);
    }
}
