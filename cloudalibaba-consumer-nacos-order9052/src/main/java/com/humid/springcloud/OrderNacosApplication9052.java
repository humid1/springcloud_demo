package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author qiujianping
 * @date Created in 2021/6/18 18:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosApplication9052 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApplication9052.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
