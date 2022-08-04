package com.maizi.mapper;

import com.maizi.domain.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author maizi
* @description 针对表【t_order】的数据库操作Mapper
* @createDate 2022-08-04 05:11:54
* @Entity com.maizi.domain.Order
*/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}




