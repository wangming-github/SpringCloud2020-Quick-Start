package com.maizi.demo.sentinel;

import com.maizi.demo.entities.Payment;
import com.maizi.demo.feign.service.PaymentFeignService;
import com.maizi.demo.module.R;
import com.maizi.demo.module.RR;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/30 23:17
 */
@Component
public class CustomerFallBack {
    public static RR<Payment> paymentSQLFallBack(Long id) {
        return RR.failed("服务降级返回 Customer FallBack");
    }
}
