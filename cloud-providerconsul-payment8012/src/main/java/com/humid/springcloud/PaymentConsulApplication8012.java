package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.swing.*;

/**
 * @author qiujianping
 * @date Created in 2021/5/6 11:52
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulApplication8012 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulApplication8012.class, args);
    }
}
