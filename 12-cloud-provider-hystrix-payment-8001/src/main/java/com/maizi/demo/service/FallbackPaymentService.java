package com.maizi.demo.service;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/24 15:52
 */
public interface FallbackPaymentService {

    String paymentInfo_OK(Integer id);


    String paymentInfo_TimeOut(Integer id);
}
