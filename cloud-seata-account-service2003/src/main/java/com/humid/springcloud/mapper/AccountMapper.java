package com.humid.springcloud.mapper;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 16:35
 */
public interface AccountMapper {
    /**
     * 扣减账号额度
     */
    int updateDecrease(@Param("userId") Long userId,
                       @Param("money") BigDecimal money);
}
