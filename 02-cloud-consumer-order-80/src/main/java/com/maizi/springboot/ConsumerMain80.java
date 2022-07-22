package com.maizi.springboot;

import com.maizi.rule.config.MyIRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/20 02:25
 */
//使用MyIRule定义的规则访问name节点服务(注意服务注册名大写)
//@RibbonClient(name = "01-CLOUD-PROVIDER-PAYMENT-SERVICE", configuration = MyIRule.class)
@EnableEurekaClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ConsumerMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain80.class, args);
    }
}
