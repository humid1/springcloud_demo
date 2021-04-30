package com.humid.springcloud.service;

import com.humid.springcloud.entities.Payment;

/**
 * @author qiujianping
 * @date Created in 2021/4/28 14:37
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
