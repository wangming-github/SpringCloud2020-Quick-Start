package com.maizi.demo.service;

import com.maizi.demo.domain.Order;

/**
 * @author maizi
 * @description 针对表【t_order】的数据库操作Services
 * @createDate 2022-08-01 04:53:11
 */
public interface OrderService {

    public void create(Order order);
}
