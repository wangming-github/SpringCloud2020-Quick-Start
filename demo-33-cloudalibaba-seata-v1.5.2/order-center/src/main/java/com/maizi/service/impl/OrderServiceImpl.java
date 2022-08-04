package com.maizi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maizi.feign.AccountFeignClient;
import com.maizi.feign.StorageFeignClient;
import com.maizi.modle.MyLog;
import com.maizi.modle.StatusEnum;
import com.maizi.domain.Order;
import com.maizi.service.OrderService;
import com.maizi.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author maizi
 * @description 针对表【t_order】的数据库操作Service实现
 * @createDate 2022-08-04 05:11:54
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    //http://localhost:8001/create?userId=1&productId=1&count=1&money=1

    @Resource
    private AccountFeignClient accountFeignClient;
    @Resource
    private StorageFeignClient storageFeignClient;

    @Override
    public boolean create(Order order) {
        final Order order1 = createOrder(order);

        storageFeignClient.take(order.getProductId(), order.getCount());

        accountFeignClient.buy(order.getUserId(), order.getMoney());

        return updateOrder(order1);
    }


    private Order createOrder(Order order) {

        order.setStatus(StatusEnum.NOTFINISH.getCode());
        order.insert();
        MyLog.info("createOrder ==>" + order);
        return order;
    }

    private boolean updateOrder(Order order) {

        order.setStatus(StatusEnum.FINISH.getCode());
        MyLog.info("updateOrder ==>" + order);
        return order.updateById();
    }

}




