package com.maizi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/4 04:51
 */
@MapperScan("com.maizi.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationAccount8003 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationAccount8003.class, args);
    }
}
