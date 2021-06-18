package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qiujianping
 * @date Created in 2021/6/18 10:07
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentAliApplication9003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentAliApplication9003.class, args);
    }
}
