package com.maizi.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 流控
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/29 03:09
 */

@Slf4j
@RestController
public class FlowLimitController {


    @GetMapping("/testA")
    public String testA() {

        //try {
        //    TimeUnit.MILLISECONDS.sleep(3000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}

        log.info(Thread.currentThread().getName());
        return "testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName());
        return "testB";
    }

    @GetMapping("/testD")
    public String testD() {
        log.info("testD 测试 异常比例");
        int age = 10 / 0;
        return "testD";
    }


    @GetMapping("/hotkey")
    @SentinelResource(value = "hotkey", //唯一标示
            blockHandler = "deal_testHotKey"//当此调用违背了在Sentinel控制台中配置的规则将执行兜底方法
    )
    public String testHotKey(@RequestParam(value = "key1", required = false) String key1, @RequestParam(value = "key2", required = false) String key2) {
        //int age = 10 / 0;
        log.info("测试 hotkey");
        return "------->testHotKey";
    }

    public String deal_testHotKey(String key1, String key2, BlockException blockException) {
        return "------->deal_testHotKey"; //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
    }
}
