package com.maizi.springboot.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @auther zzyy
 * @create 2020-02-19 20:31
 */
public interface MyLoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
