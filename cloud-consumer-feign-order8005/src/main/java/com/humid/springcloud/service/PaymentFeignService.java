package com.humid.springcloud.service;

import com.humid.springcloud.entities.CommonResult;
import com.humid.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author qiujianping
 * @date Created in 2021/5/17 16:32
 */
@FeignClient(value = "cloud-provider-service")
public interface PaymentFeignService {

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment);

    @GetMapping("/payment/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id);
}
