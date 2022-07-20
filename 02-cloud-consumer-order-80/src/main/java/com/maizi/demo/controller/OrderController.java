package com.maizi.demo.controller;

import com.maizi.demo.entities.Payment;
import com.maizi.demo.module.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/20 02:29
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001";

    public static final String PAYMENT_URL = "http://01-CLOUD-PROVIDER-PAYMENT-SERVICE";

    @Resource
    RestTemplate restTemplate;


    /**
     * 添加
     *
     * @param payment
     * @return
     */
    @GetMapping("/payment/save")
    public R create(Payment payment) {
        log.info("======>Payment:{}", payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, R.class);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/{id}")
    public R create(@PathVariable("id") Long id) {
        log.info("======>id:{}", id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, R.class);
    }

}
