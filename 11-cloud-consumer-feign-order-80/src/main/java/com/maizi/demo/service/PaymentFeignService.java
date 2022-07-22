package com.maizi.demo.service;

import com.maizi.demo.entities.Payment;
import com.maizi.demo.module.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/23 03:13
 */

@Component
@FeignClient("01-CLOUD-PROVIDER-PAYMENT-SERVICE")//注册中心中服务节点名称
public interface PaymentFeignService {

    /**
     * 直接复制对应服务节点的controller方法及其注解
     */
    @GetMapping(value = "/payment/{id}")
    R<Payment> getById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();

}
