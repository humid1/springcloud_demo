package com.humid.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author qiujianping
 * @date Created in 2021/6/16 11:45
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        // TimeUnit.SECONDS.sleep(2);
        log.info(Thread.currentThread().getName()+"\t"+"...testA");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.info(Thread.currentThread().getName()+"\t"+"...testC");
        return "------testC";
    }

    @GetMapping("/testD")
    public String testD() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.info(Thread.currentThread().getName()+"\t"+"...testD");
        int a = 10/0;
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() throws InterruptedException {
        log.info(Thread.currentThread().getName()+"\t"+"...testE");
        int a = 10/0;
        return "------testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKey";
    }

    public String dealTestHotKey(String p1, String p2, BlockException blockException) {
        // 系统默认提示：Blocked by Sentinel (flow limiting)
        return "---------dealTestHotKey, o(╥﹏╥)o !";
    }
}
