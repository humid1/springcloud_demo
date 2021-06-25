package com.humid.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 16:24
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@MapperScan(basePackages = "com.humid.springcloud.mapper")
public class SeataStorageApplication2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageApplication2002.class, args);
    }
}
