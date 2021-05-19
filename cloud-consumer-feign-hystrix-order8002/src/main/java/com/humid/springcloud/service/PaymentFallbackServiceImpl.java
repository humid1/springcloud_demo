package com.humid.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author qiujianping
 * @date Created in 2021/5/18 17:45
 */
@Component
public class PaymentFallbackServiceImpl implements FallbackFactory<PaymentHystrixService> {
    @Override
    public PaymentHystrixService create(Throwable cause) {
        return new PaymentHystrixService() {
            @Override
            public String paymentInfoOk(Integer id) {
                return "******* PaymentFallbackService fall paymentInfoOk, o(╥﹏╥)o！";
            }

            @Override
            public String paymentInfoTimeOut(Integer id) {
                return "******* PaymentFallbackService fall paymentInfoTimeOut, o(╥﹏╥)o！";
            }
        };
    }
}
