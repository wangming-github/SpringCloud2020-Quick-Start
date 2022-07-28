package com.maizi.demo.service.impl;


import com.maizi.demo.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 消息发送者
 * 不需要@Service注解了 不同于 增删改查
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/27 03:27
 * @see Source  ==> @EnableBinding(Source.class)
 */
@Slf4j
@EnableBinding(Source.class) //定义消息的推送管道
public class IMessageProviderImpl implements IMessageProvider {


    @Resource
    private MessageChannel output;

    /**
     * 消息发送队列
     */
    @Resource
    @Qualifier(Source.OUTPUT)
    private MessageChannel outputChannel;


    /**
     * 发送消息
     */
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        outputChannel.send(MessageBuilder.withPayload(serial).build());
        log.info("=====>send message:{} ", serial);
        return null;
    }
}
