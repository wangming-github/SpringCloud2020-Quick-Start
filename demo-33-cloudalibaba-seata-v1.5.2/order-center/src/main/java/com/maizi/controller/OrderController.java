package com.maizi.controller;

import com.maizi.modle.R;
import com.maizi.domain.Order;
import com.maizi.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/4 05:26
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/create")
    public R create(Order order) {
        return R.succeed(orderService.create(order));
    }

}
