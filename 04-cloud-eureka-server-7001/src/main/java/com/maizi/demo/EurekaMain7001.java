package com.maizi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/20 04:29
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaServer //标注为此服务为注册中心
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
