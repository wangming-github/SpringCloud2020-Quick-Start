package com.maizi.springboot.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/20 02:33
 */
@Configuration
public class ApplicationContextConfig {

    //远程调用8001服务方法：
    //1.自定义：httpClient
    //2.使用封装后的：RestTemplate
    //RestTemplate提供了多种便捷访问远程Http服务的方法,是一种简单便捷的访问restful服务模板类，
    // 是Spring提供的用于访问Rest服务的客户端模板工具集

    @Bean
    //@LoadBalanced //这个注解让我的服务具有负载均衡的能力，这样就不会报错了java.net.UnknownHostException: 01-CLOUD-PROVIDER-PAYMENT-SERVICE
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
