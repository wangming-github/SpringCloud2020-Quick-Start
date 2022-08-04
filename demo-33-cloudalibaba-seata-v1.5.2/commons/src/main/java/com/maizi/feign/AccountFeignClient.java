package com.maizi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/4 09:47
 */
@FeignClient("account-serve-center")
public interface AccountFeignClient {


    /**
     * 购买货物
     *
     * @param userId 用户id
     * @param money  金钱
     * @return
     */
    @PostMapping("/buy")
    boolean buy(@RequestParam("userId") Long userId, @RequestParam("money") Long money);

}
