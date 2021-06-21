package com.humid.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.humid.springcloud.entities.CommonResult;
import com.humid.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author qiujianping
 * @date Created in 2021/6/21 9:16
 */
@RestController
public class CircleBreakerController {
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    // @SentinelResource(value = "fallback") // 没有配置
    // @SentinelResource(value = "fallback", fallback = "handlerFallback") // fallback只负责业务异常
    // @SentinelResource(value = "fallback", blockHandler = "blockHandler") // bloclckHandler只负责sentinel控制台配置限流
    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "handlerFallback")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(serviceUrl + "/paymentSQL/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else {
            assert result != null;
            if (result.getData() == null) {
                throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
            }
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<Payment>(444, "兜底异常handlerFallback，excetion内容" + e.getMessage(), payment);
    }

    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException blockException) {
        Payment payment = new Payment(id, null);
        return new CommonResult(445, "blockHandler-sentinel限流,无此流水: blockException  " + blockException.getMessage(), payment);
    }
}
