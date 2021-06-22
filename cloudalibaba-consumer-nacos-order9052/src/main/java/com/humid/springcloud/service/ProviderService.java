package com.humid.springcloud.service;

import com.humid.springcloud.entities.CommonResult;
import com.humid.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author qiujianping
 * @date Created in 2021/6/21 16:52
 */
@FeignClient(value = "nacos-payment-provider", fallbackFactory = ProviderFallbackFactory.class)
public interface ProviderService {
    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}


