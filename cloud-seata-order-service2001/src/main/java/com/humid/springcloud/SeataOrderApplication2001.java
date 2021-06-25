package com.humid.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 15:44
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan({"com.humid.springcloud.mapper"})
public class SeataOrderApplication2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderApplication2001.class, args);
    }
}
