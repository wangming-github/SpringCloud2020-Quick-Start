package com.maizi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/20 02:25
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class ConsumerMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain80.class, args);
    }
}
