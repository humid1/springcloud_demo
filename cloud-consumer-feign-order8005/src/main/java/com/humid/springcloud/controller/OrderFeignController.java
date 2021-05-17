package com.humid.springcloud.controller;

import com.humid.springcloud.entities.CommonResult;
import com.humid.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiujianping
 * @date Created in 2021/5/17 16:39
 */
@RestController
@RequestMapping(value = "/consumer")
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id) {
        return paymentFeignService.getById(id);
    }

    @GetMapping("/feign/timeout")
    public String feignTimeout() {
        return paymentFeignService.feignTimeout();
    }
}
