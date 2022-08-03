package com.maizi.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 远程调用账户服务
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/1 06:34
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {


    /**
     * 账户金额扣除 post请求
     *
     * @param userId 用户id
     * @param money  扣除金额
     * @return 执行结果
     */
    @PostMapping("/account/decrease")
    boolean decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
