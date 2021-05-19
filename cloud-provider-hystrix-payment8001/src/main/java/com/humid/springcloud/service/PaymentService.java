package com.humid.springcloud.service;

import com.humid.springcloud.entities.Payment;

/**
 * @author qiujianping
 * @date Created in 2021/4/28 14:37
 */
public interface PaymentService {

    String paymentInfoOk(Integer id);

    String paymentInfoTimeout(Integer id);

    String paymentCircuitBreaker(Integer id);
}
