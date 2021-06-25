package com.humid.springcloud.api;

import com.humid.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 15:25
 * 调用账户api
 */
@FeignClient(value = "seata-account-service")
public interface AccountApi {
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId,
                          @RequestParam("money")BigDecimal money);
}
