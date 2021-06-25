package com.humid.springcloud.controller;

import com.humid.springcloud.entities.CommonResult;
import com.humid.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 16:17
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "库存扣减成功！");
    }
}
