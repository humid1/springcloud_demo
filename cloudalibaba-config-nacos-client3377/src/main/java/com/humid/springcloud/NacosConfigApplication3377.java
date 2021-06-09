package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qiujianping
 * @date Created in 2021/6/9 14:56
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigApplication3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication3377.class, args);
    }
}
