package com.humid.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author qiujianping
 * @date Created in 2021/5/6 11:54
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymentConsul() {
        return "springcloud with consul: " + serverPort + "\t" + UUID.randomUUID();
    }
}
