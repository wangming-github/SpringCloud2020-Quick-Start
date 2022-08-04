package com.maizi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/4 04:51
 */
@MapperScan("com.maizi.mapper")
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationOrder8001 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationOrder8001.class, args);
    }
}
