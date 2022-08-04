package com.maizi.controller;

import com.maizi.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/4 05:26
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping("/take")
    private boolean take(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        return storageService.take(productId, count);

    }

}




