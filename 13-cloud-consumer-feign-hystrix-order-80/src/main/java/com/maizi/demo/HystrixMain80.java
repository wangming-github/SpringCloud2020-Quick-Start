package com.maizi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/24 17:47
 */
@EnableHystrix
@EnableFeignClients //开启Feign远程调用
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class HystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMain80.class, args);
    }
}
