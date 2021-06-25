package com.humid.springcloud.controller;

import com.humid.springcloud.domain.Order;
import com.humid.springcloud.entities.CommonResult;
import com.humid.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 15:39
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
