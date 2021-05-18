package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author qiujianping
 * @date Created in 2021/5/18 14:50
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixApplication8002.class, args);
    }
}
