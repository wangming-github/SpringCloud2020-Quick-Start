package com.maizi.demo.feign.fallback;

import com.maizi.demo.entities.Payment;
import com.maizi.demo.module.R;
import com.maizi.demo.feign.service.PaymentFeignService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/30 23:34
 */
@Slf4j
@Component
public class ServiceFallBackFactory implements FallbackFactory<PaymentFeignService> {
    @Override
    public PaymentFeignService create(Throwable throwable) {
        return new PaymentFeignService() {
            @Override
            public Payment paymentSQL(Long id) {
                log.info("远程调用支付模块失败,id=" + id);
                return null;
            }
        };
    }
}
