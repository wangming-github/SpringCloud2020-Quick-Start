package com.maizi.demo.controller;

import com.maizi.demo.entities.Payment;
import com.maizi.demo.module.R;
import com.maizi.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/20 01:05
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPost;


    @PostMapping(value = "/payment/save")
    public R create(@RequestBody Payment payment) {
        log.info("======>Payment : " + payment);

        if (paymentService.save(payment)) {
            return new R(200, "成功！" + serverPost, true);
        } else {
            return new R(444, "失败！" + serverPost, false);
        }
    }


    @GetMapping(value = "/payment/{id}")
    public R getById(@PathVariable("id") Long id) {
        final Payment payment = paymentService.getById(id);
        log.info("======>Payment find: " + payment);
        if (payment != null) {
            return new R(200, "成功！" + serverPost, payment);
        } else {
            return new R(444, "失败！" + serverPost);
        }
    }


}
