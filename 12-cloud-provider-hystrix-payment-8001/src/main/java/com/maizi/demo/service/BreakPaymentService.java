package com.maizi.demo.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/25 01:20
 */
public interface BreakPaymentService {

    String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
