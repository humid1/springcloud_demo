package com.humid.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiujianping
 * @date Created in 2021/6/1 17:59
 */
@RestController
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/get")
    public String getInfo() {
        return configInfo;
    }
}
