package com.maizi.demo.service.impl;

import cn.hutool.core.util.IdUtil;
import com.maizi.demo.service.BreakPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * 服务熔断
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/24 15:50
 */
@Service
public class BreakPaymentServiceImpl implements BreakPaymentService {

    /**
     * @see com.netflix.hystrix.HystrixCommandProperties
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", //
            commandProperties = {//
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
            })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("========>id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "fallbackMethod 返回：id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }

}
