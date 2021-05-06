package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qiujianping
 * @date Created in 2021/5/6 14:10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulApplication8004 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulApplication8004.class, args);
    }
}
