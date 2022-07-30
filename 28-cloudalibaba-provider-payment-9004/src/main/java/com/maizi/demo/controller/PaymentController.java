package com.maizi.demo.controller;

import com.maizi.demo.entities.Payment;
import com.maizi.demo.module.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/30 06:00
 */
@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    //模拟DB查询
    static {
        hashMap.put(1L, new Payment(1L, "28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L, new Payment(2L, "bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3L, new Payment(3L, "6ua8c1e3bc2742d8848569891xt92183"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public Payment paymentSQL(@PathVariable("id") Long id) {
        final Payment payment = hashMap.get(id);
        log.info("远程调用支付模块,端口:{}/paymentSQL/{}  返回:{}", serverPort, id, payment);
        //故意添加异常 当id>3就触发
        if (payment == null) {
            throw new NullPointerException("未能找到id为" + id + "的数据");
        }
        return payment;
    }

}
