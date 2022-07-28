package com.maizi.demo.service;

import com.maizi.demo.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/24 17:52
 */
@FeignClient(value = "12-CLOUD-PROVIDER-HYSTRIX-PAYMENT-8001", fallback = PaymentFallbackService.class)
public interface FeignPaymentServer {


    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}



