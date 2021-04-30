package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author qiujianping
 * @date Created in 2021/4/30 10:17
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentApplication8010 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8010.class, args);
    }
}
