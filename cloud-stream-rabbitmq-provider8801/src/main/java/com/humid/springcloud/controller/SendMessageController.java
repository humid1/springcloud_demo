package com.humid.springcloud.controller;

import com.humid.springcloud.provider.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qiujianping
 * @date Created in 2021/6/3 17:45
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;
    
    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
