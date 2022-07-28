package com.maizi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/27 03:24
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StreamRabbitMQMain8802 {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQMain8802.class, args);
    }
}
