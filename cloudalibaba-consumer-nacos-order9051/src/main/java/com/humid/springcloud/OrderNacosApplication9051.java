package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qiujianping
 * @date Created in 2021/6/9 11:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosApplication9051 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApplication9051.class, args);
    }
}
