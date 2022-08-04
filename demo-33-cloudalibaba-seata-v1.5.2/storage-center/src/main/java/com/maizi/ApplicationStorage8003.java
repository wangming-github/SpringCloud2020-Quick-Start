package com.maizi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/4 19:38
 */

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.maizi.mapper")
public class ApplicationStorage8003 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStorage8003.class, args);
    }
}
