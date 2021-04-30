package com.humid.springcloud.service.impl;

import com.humid.springcloud.entities.Payment;
import com.humid.springcloud.mapper.PaymentMapper;
import com.humid.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiujianping
 * @date Created in 2021/4/28 14:37
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
