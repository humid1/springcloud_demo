package com.humid.springcloud.service;

import com.humid.springcloud.domain.Order;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 11:51
 */
public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);

}
