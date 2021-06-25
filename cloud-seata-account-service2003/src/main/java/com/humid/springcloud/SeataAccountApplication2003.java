package com.humid.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 16:32
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@MapperScan("com.humid.springcloud.mapper")
public class SeataAccountApplication2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountApplication2003.class, args);
    }
}
