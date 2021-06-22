package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author qiujianping
 * @date Created in 2021/6/18 18:03
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderNacosApplication9052 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApplication9052.class, args);
    }
}
