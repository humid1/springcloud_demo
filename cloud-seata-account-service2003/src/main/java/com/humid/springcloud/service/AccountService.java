package com.humid.springcloud.service;

import java.math.BigDecimal;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 16:51
 */
public interface AccountService {
    /**
     * 扣减账号余额
     */
    void decrease(Long userId, BigDecimal money);
}
