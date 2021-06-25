package com.humid.springcloud.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 16:02
 */
public interface StorageMapper {
    /**
     * 扣减库存
     * @return
     * @param productId
     * @param count
     */
    int updateDecrease(@Param("productId") Long productId, @Param("count") Integer count);
}