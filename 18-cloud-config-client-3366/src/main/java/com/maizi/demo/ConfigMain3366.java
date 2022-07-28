package com.maizi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/26 04:36
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3366.class, args);
    }
}