package com.humid.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.humid.springcloud.entities.CommonResult;
import com.humid.springcloud.entities.Payment;
import com.humid.springcloud.handler.CustomerBlockHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiujianping
 * @date Created in 2021/6/17 17:22
 */
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2021L, "serial001"));
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按URL限流测试OK", new Payment(2021L, "serial002"));
    }

    @GetMapping("/customBlockHandler")
    @SentinelResource(value = "customBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customBlockHandler() {
        return new CommonResult(200, "按用户自定义限流测试OK", new Payment(2021L, "serial003"));
    }

    public CommonResult handleException(BlockException blockException) {
        return new CommonResult(415, blockException.getClass().getCanonicalName() + "\t 服务不可用");
    }

}
