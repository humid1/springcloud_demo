package com.humid.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.humid.springcloud.entities.CommonResult;

/**
 * @author qiujianping
 * @date Created in 2021/6/17 17:48
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义," + exception.getClass().getCanonicalName() + ",global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义," + exception.getClass().getCanonicalName() + ", global handlerException----2");
    }
}
