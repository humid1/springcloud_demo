package com.humid.springcloud.service.impl;

import com.humid.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author qiujianping
 * @date Created in 2021/4/28 14:37
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_ok, id:" + id + "\tO(∩_∩)O哈哈~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeout(Integer id) {
        int timeOutNum = 3;
        // int b = 10/0;
        try {
            TimeUnit.SECONDS.sleep(timeOutNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_ok, id:" + id + "\tO(∩_∩)O哈哈~ 耗时 " + timeOutNum + " 秒";
    }

    private String paymentInfoTimeoutHandle(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " 服务8001，系统繁忙或运行报错，请稍后重试！" + id + "\to(╥﹏╥)o";
    }
}
