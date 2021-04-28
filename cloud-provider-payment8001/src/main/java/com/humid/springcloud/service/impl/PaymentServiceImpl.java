package com.humid.springcloud.service.impl;

import com.humid.springcloud.dao.PaymentDao;
import com.humid.springcloud.entities.Payment;
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
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
