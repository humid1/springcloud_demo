package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author qiujianping
 * @date Created in 2021/5/17 16:23
 */
@SpringBootApplication
@EnableFeignClients
public class OpenFeignApplication8005 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication8005.class, args);
    }
}
