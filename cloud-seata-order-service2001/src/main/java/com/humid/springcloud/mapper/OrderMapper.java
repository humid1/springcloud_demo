package com.humid.springcloud.mapper;

import com.humid.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 11:28
 */
public interface OrderMapper {
    /**
     * 新建订单
     */
    int create(Order order);

    /**
     * 修改订单状态，0 --> 1
     */
    int update(@Param("userId") Long userId, @Param("status") Integer status);
}
