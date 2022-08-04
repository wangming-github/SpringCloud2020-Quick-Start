package com.maizi.controller;

import com.maizi.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/4 05:25
 */

@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    @RequestMapping("/buy")
    public boolean buy(@RequestParam("userId") Long userId, @RequestParam("money") Long money) {
        return accountService.buy(userId, money);
    }

}
