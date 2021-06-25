package com.humid.springcloud.service.impl;

import com.humid.springcloud.api.AccountApi;
import com.humid.springcloud.api.StorageApi;
import com.humid.springcloud.domain.Order;
import com.humid.springcloud.mapper.OrderMapper;
import com.humid.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 15:17
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AccountApi accountApi;

    @Autowired
    private StorageApi storageApi;

    /**
     * 创建订单 -> 调用库存服务扣减库存 -> 调用账户服务扣减余额 -> 修改订单状态
     * 下订单 -> 扣库存 -> 减余额 -> 改状态
     * rollbackFor = Exception.class表示对任意异常都进行回滚
     * @param order
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-----> 1. 开始新建订单");
        orderMapper.create(order);

        log.info("-----> 2. 订单微服务开始调用库存，做扣减 start");
        storageApi.decrease(order.getProductId(), order.getCount());
        log.info("-----> 订单微服务开始调用库存，做扣减 end");

        log.info("-----> 3. 订单微服务开始调用账号，做扣减 Money");
        accountApi.decrease(order.getUserId(), order.getMoney());
        log.info("-----> 订单微服务开始调用账号，做扣减 end");

        log.info("-----> 4. 修改订单状态(0 -> 1 代表已完成) start");
        orderMapper.update(order.getUserId(), 1);
        log.info("-----> 修改订单状态 end");
        log.info("下单结束了，O(∩_∩)O哈哈~");
    }
}
