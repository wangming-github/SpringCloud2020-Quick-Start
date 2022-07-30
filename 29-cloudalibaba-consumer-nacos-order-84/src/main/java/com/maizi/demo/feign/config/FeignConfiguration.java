package com.maizi.demo.feign.config;

import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * FeignConfiguration是配置Feign配置类，在配置类中可以自定义Feign的Encoder、Decoder、LogLevel、Contract等。
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/30 23:58
 */
@Component
public class FeignConfiguration {

    @Bean
    public Logger.Level getLoggerLevel() {
        return Logger.Level.FULL;
    }


    @Bean
    public ErrorDecoder errorDecoder() {
        return new MyErrorDecoder();
    }


}
