package com.maizi.demo.service;

import com.maizi.demo.entities.Payment;
import com.maizi.demo.module.R;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/31 01:32
 */
public interface OrderService {
    Payment paymentSQL(@PathVariable("id") Long id);
}
