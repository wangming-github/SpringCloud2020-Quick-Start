package com.maizi.demo.feign.service;

import com.maizi.demo.entities.Payment;
import com.maizi.demo.feign.config.FeignConfiguration;
import com.maizi.demo.feign.fallback.ServiceFallBack;
import com.maizi.demo.feign.fallback.ServiceFallBackFactory;
import com.maizi.demo.module.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/30 23:16
 */
@FeignClient(//
        value = "${service-url.nacos-user-service}",//
        fallback = ServiceFallBack.class,//
        //fallbackFactory = ServiceFallBackFactory.class,//服务降级逻辑，可以知道熔断的异常信息。
        path = "paymentSQL",//
        decode404 = true//当调用请求发生404错误时，decode404的值为true，那么会执行decoder解码，否则抛出异常。
)
public interface PaymentFeignService {

    @GetMapping(value = "/{id}")
    Payment paymentSQL(@PathVariable("id") Long id);

}


