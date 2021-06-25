package com.humid.springcloud.service.impl;

import com.humid.springcloud.mapper.AccountMapper;
import com.humid.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 16:52
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        accountMapper.updateDecrease(userId, money);
        log.info("------->account-service中扣减账户余额结束");
    }
}
