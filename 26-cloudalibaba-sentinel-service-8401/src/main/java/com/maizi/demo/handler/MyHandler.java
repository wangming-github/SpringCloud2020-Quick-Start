package com.maizi.demo.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.maizi.demo.module.R;


public class MyHandler {

    public static R myBlockHandler(BlockException exception) {
        return new R(444, "按客戶自定义 返回异常");
    }
}




