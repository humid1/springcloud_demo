package com.humid.springcloud.service;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 16:13
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
