package com.humid.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author qiujianping
 * @date Created in 2021/6/9 11:58
 */
@RestController
@RequestMapping("/consumer")
public class OrderNacosController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-server}")
    private String serverUrl;

    @GetMapping("/payment/nacos/{id}")
    public String getPaymentInfo(@PathVariable("id") Long id) {
        return restTemplate.postForObject(serverUrl + "/payment/nacos/" + id, null, String.class);
    }
}
