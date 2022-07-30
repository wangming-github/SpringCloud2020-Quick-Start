package com.maizi.demo.service;

import com.maizi.demo.entities.Payment;
import com.maizi.demo.feign.service.PaymentFeignService;
import com.maizi.demo.module.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/31 01:31
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    PaymentFeignService paymentFeignService;

    @Override
    public Payment paymentSQL(Long id) {
        final Payment payment = paymentFeignService.paymentSQL(id);
        if (payment == null) {
            log.error("远程调用结果为空!");
            throw new NullPointerException("远程调用结果为空!");
        }
        log.info("远程调用结果正常!");
        return payment;
    }
}
