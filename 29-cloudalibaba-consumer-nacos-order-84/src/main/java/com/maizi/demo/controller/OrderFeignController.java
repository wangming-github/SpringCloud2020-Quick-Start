package com.maizi.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.maizi.demo.entities.Payment;
import com.maizi.demo.feign.service.PaymentFeignService;
import com.maizi.demo.module.R;
import com.maizi.demo.module.RR;
import com.maizi.demo.sentinel.CustomerBlockHandler;
import com.maizi.demo.sentinel.CustomerFallBack;
import com.maizi.demo.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/31 00:15
 */
@RestController
public class OrderFeignController {
    @Resource
    private OrderService orderService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    @SentinelResource(//
            value = "paymentSQL",//
            fallbackClass = CustomerFallBack.class,//
            fallback = "paymentSQLFallBack",//
            blockHandlerClass = CustomerBlockHandler.class, //
            blockHandler = "paymentSQLBlockHandler")
    public RR<Payment> paymentSQL(@PathVariable("id") Long id) {
        return RR.succeed(orderService.paymentSQL(id));
    }
}
