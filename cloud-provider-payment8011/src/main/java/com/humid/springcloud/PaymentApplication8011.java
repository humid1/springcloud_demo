package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qiujianping
 * @date Created in 2021/4/30 16:04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication8011 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8011.class, args);
    }
}
