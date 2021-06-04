package com.humid.springcloud.provider;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author qiujianping
 * @date Created in 2021/6/3 17:37
 */
@EnableBinding(Source.class) // 定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    @Resource(name = Source.OUTPUT)
    private MessageChannel messageChannel;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        messageChannel.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial ************ " + serial);
        return serial;
    }
}
