package com.maizi.demo.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.maizi.demo.entities.Payment;
import com.maizi.demo.module.R;
import com.maizi.demo.module.RR;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/31 01:02
 */
@Component
public class CustomerBlockHandler {

    public static RR<Payment> paymentSQLBlockHandler(@PathVariable("id") Long id, BlockException exception) {
        return RR.failed("服务降级返回 Customer BlockHandler" + exception.getRuleLimitApp());
    }
}
