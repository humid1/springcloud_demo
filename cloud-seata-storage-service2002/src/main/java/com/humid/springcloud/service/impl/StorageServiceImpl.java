package com.humid.springcloud.service.impl;

import com.humid.springcloud.mapper.StorageMapper;
import com.humid.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 16:14
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("----> storage-service 中扣减库存 start");
        storageMapper.updateDecrease(productId, count);
        log.info("----> storage-service 中扣减库存 end");
    }
}
