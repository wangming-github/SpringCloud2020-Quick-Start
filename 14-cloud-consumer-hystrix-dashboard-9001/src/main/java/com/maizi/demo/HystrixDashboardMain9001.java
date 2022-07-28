package com.maizi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/25 04:03
 */
@EnableHystrixDashboard
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }
}
