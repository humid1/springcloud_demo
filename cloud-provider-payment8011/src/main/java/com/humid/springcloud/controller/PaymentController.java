package com.humid.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author qiujianping
 * @date Created in 2021/4/30 16:51
 */
@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zk")
    public Object paymentZk() {
        return "spirngcloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID();
    }

}
