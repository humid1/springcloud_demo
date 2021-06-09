package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qiujianping
 * @date Created in 2021/6/7 15:07
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentAliApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentAliApplication9001.class, args);
    }
}
