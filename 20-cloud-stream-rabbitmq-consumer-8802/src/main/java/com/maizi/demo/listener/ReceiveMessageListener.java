package com.maizi.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/27 03:49
 */
@Slf4j
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListener {


    @Value("${server.port}")
    private String serverPort;

    //监听队列，用于消费者的队列的消息接收
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {//类型一致
        log.info("=====> input: " + message.getPayload() + "\t" + serverPort);
    }

}
