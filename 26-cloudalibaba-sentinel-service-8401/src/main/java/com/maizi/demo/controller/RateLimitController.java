package com.maizi.demo.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.maizi.demo.entities.Payment;
import com.maizi.demo.handler.CustomerBlockHandler;
import com.maizi.demo.handler.MyHandler;
import com.maizi.demo.module.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/30 03:12
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public R byResource() {
        return new R(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public R handleException(BlockException exception) {
        return new R(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public R byUrl() {
        return new R(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public R customerBlockHandler() {
        return new R(200, "按客戶自定义", new Payment(2020L, "serial003"));
    }


    @GetMapping("/myBlockHandler")
    @SentinelResource(value = "myBlockHandler", blockHandlerClass = MyHandler.class, blockHandler = "myBlockHandler")
    public R myBlockHandler() {
        return new R(200, "按客戶自定义", new Payment(2020L, "serial003"));
    }
}