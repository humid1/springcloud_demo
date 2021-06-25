package com.humid.springcloud.api;

import com.humid.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 14:26
 * 调用库存api
 */
@FeignClient(value = "seata-storage-service")
public interface StorageApi {
    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,
                          @RequestParam("count") Integer count);
}
