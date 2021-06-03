package com.humid.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiujianping
 * @date Created in 2021/6/2 15:37
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/get")
    public String getConfigInfo() {
        return "serverPort: " + serverPort + "\t\nconfigInfo: " + configInfo;
    }
}
