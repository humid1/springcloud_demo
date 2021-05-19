package com.humid.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.humid.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author qiujianping
 * @date Created in 2021/4/28 14:37
 */
@Service
// @DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_ok, id:" + id + "\tO(∩_∩)O哈哈~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    // @HystrixCommand
    public String paymentInfoTimeout(Integer id) {
        int timeOutNum = 3;
        int b = 10/0;
        // try {
        //     TimeUnit.SECONDS.sleep(timeOutNum);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_ok, id:" + id + "\tO(∩_∩)O哈哈~ 耗时 " + timeOutNum + " 秒";
    }

    /**
     * 服务熔断
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期 10s
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率多少后跳闸
    })
    @Override
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("******* id不能为负数 *******");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t调用成功，流水号为：" + uuid;
    }

    private String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

    private String paymentInfoTimeoutHandle(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " 服务8001，系统繁忙或运行报错，请稍后重试！" + id + "\to(╥﹏╥)o";
    }

    /**
     * 下面是全局fallback方法
     */
    public String paymentGlobalFallbackMethod() {
        return "线程池：" + Thread.currentThread().getName() + " 服务8001，系统繁忙或运行报错，请稍后重试！\to(╥﹏╥)o";
    }
}
