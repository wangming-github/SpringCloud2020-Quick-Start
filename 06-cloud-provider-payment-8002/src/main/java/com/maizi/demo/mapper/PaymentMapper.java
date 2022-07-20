package com.maizi.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maizi.demo.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author maizi
 * @description 针对表【payment】的数据库操作Mapper
 * @createDate 2022-07-20 00:42:49
 * @Entity com.maizi.demo.entities.Payment
 */

@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {


    int insertAll(Payment payment);

    List<Payment> getById(@Param("id") Long id);

}




