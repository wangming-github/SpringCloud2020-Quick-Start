package com.maizi.demo.feign.fallback;

import com.maizi.demo.feign.AccountService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/30 23:34
 */
@Slf4j
@Component
public class AccountServiceFallBackFactory implements FallbackFactory<AccountService> {
    @Override
    public AccountService create(Throwable throwable) {
        return new AccountService() {

            /**
             * 账户金额扣除 post请求
             *
             * @param userId 用户id
             * @param money  扣除金额
             * @return 执行结果
             */
            @Override
            public boolean decrease(Long userId, BigDecimal money) {
                log.error("远程调用 账户金额扣除模块userId:{},money:{} 失败:{}", userId, money, throwable.getMessage());
                return false;
            }
        };
    }
}
