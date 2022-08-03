package com.maizi.demo.mapper;

import com.maizi.demo.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author maizi
 * @description 针对表【t_order】的数据库操作Mapper
 * @createDate 2022-08-01 04:53:11
 * @Entity com.maizi.demo.domain.Order
 */
@Mapper
public interface OrderMapper {


    //1 新建订单
    void create(Order order);

    //2 修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}



