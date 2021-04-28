package com.humid.springcloud.controller;

import com.humid.springcloud.entities.CommonResult;
import com.humid.springcloud.entities.Payment;
import com.humid.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qiujianping
 * @date Created in 2021/4/28 14:39
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(Payment payment) {
        int i = paymentService.create(payment);
        log.info("插入结果是:{}", i);
        if (i > 0) {
            return new CommonResult(200, "插入数据成功！", i);
        } else {
            return new CommonResult(500, "插入数据失败！");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null == payment) {
            return new CommonResult(519, "没有对应记录");
        }
        return new CommonResult(200, "查询成功", payment);
    }
}
