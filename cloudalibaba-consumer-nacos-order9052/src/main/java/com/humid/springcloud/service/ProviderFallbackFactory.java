package com.humid.springcloud.service;

import com.humid.springcloud.entities.CommonResult;
import com.humid.springcloud.entities.Payment;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author qiujianping
 * @date Created in 2021/6/21 18:28
 */
@Component
public class ProviderFallbackFactory implements FallbackFactory<ProviderService> {

    @Override
    public ProviderService create(Throwable cause) {
        return new ProviderService() {
            @Override
            public CommonResult<Payment> paymentSQL(Long id) {
                return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
            }
        };
    }
}
