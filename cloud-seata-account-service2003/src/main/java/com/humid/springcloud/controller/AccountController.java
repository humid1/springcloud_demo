package com.humid.springcloud.controller;

import com.humid.springcloud.entities.CommonResult;
import com.humid.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 16:54
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,
                                 @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        //模拟超时异常，全局事务回滚
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(200, "账户扣减余额成功");
    }
}
