package com.maizi.service;

import com.maizi.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author maizi
* @description 针对表【t_order】的数据库操作Service
* @createDate 2022-08-04 05:11:54
*/
public interface OrderService extends IService<Order> {

    boolean create(Order order);
}
