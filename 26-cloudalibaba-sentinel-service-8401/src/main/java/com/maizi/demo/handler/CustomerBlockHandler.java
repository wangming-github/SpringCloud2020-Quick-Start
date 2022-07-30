package com.maizi.demo.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.maizi.demo.module.R;

/**
 * @author maizi
 * @create 2020-02-25 15:32
 */
public class CustomerBlockHandler {
    public static R handlerException(BlockException exception) {
        return new R(4444, "按客戶自定义,global handlerException----1");
    }

    public static R handlerException2(BlockException exception) {
        return new R(4444, "按客戶自定义,global handlerException----2");
    }
}
