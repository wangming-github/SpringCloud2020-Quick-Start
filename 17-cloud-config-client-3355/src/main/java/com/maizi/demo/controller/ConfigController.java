package com.maizi.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/26 04:49
 */

@RestController
@RefreshScope
public class ConfigController {
    @Value("${my.name}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
