package com.humid.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author qiujianping
 * @date Created in 2021/6/1 17:11
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterApplication3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterApplication3344.class, args);
    }
}
