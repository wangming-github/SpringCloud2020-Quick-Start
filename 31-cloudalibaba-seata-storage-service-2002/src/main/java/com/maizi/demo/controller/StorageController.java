package com.maizi.demo.controller;

import com.maizi.demo.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/1 21:37
 */

@Slf4j
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Resource
    private StorageService storageService;


    @RequestMapping("/decrease")
    public boolean decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        log.info("=====>productId: " + productId);
        return storageService.decrease(productId, count);
    }


}
