package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qiujianping
 * @date Created in 2021/5/6 10:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkApplication8003 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkApplication8003.class, args);
    }
}
