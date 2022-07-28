package com.maizi.demo.controller;

import com.maizi.demo.service.FeignPaymentServer;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/24 17:54
 */

@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
@RestController
public class OrderController {

    @Resource
    FeignPaymentServer feignPaymentServer;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String paymentInfoOK(@PathVariable("id") Integer id) {
        return feignPaymentServer.paymentInfo_OK(id);
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80,对方支付系统繁忙,请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    /**
     * 定制fallback方法
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", //
            commandProperties = {@HystrixProperty(//
                    name = "execution.isolation.thread.timeoutInMilliseconds", //
                    value = "1500")})
    String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        return feignPaymentServer.paymentInfo_TimeOut(id);
    }


    /**
     * 全局fallback方法
     */
    @GetMapping("/consumer/payment/hystrix/timeout/global/{id}")
    @HystrixCommand
    String paymentInfoTimeOutGlobal(@PathVariable("id") Integer id) {
        return feignPaymentServer.paymentInfo_TimeOut(id);
    }

    /**
     * 下面是全局fallback方法
     */
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
