package com.maizi.demo.service.impl;

import com.maizi.demo.service.FeignPaymentServer;
import org.springframework.stereotype.Component;


/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/25 00:15
 */
@Component
public class PaymentFallbackService implements FeignPaymentServer {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK " + id + " 异常返回!";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut " + id + " 异常返回!";
    }
}
