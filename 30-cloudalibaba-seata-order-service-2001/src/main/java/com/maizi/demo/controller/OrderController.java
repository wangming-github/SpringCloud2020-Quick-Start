package com.maizi.demo.controller;

import com.maizi.demo.domain.Order;
import com.maizi.demo.module.vo.CommonResult;
import com.maizi.demo.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/1 05:03
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
