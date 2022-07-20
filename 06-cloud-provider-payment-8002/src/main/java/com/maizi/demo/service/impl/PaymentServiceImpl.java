package com.maizi.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maizi.demo.entities.Payment;
import com.maizi.demo.mapper.PaymentMapper;
import com.maizi.demo.service.PaymentService;
import org.springframework.stereotype.Service;

/**
* @author maizi
* @description 针对表【payment】的数据库操作Service实现
* @createDate 2022-07-20 00:42:49
*/
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment>
    implements PaymentService{

}




