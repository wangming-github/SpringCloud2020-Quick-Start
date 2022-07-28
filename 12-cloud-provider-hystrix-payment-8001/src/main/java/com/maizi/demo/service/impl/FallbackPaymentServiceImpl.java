package com.maizi.demo.service.impl;

import com.maizi.demo.service.FallbackPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 服务降级
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/24 15:50
 */
@Service
public class FallbackPaymentServiceImpl implements FallbackPaymentService {

    /**
     * 正常访问，肯定OK
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "  paymentInfo_OK,id:  " + id + "\t" + "O(∩_∩)O哈哈~";
    }


    /**
     * 模拟超时
     * //设置自身调用超时时间的峰值，峰值内可以正常运行
     * //超过了需要有兜底的方法处理，作服务降级fallback
     */

    @Override
    @HystrixCommand(//
            fallbackMethod = "paymentInfo_TimeOutHandler",//兜底方法
            commandProperties = {//执行方法的线程超时时间
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + "paymentInfo_TimeOut id:  " + id + "\t" + "O(∩_∩)O哈哈~" + "  耗时(毫秒): " + timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {

        return "线程池:  " + Thread.currentThread().getName() + "8001:系统繁忙或者运行报错，请稍后再试,id:" + id + "\t" + "o(╥﹏╥)o";
    }
}
