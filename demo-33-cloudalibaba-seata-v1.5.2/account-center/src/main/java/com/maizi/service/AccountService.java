package com.maizi.service;

import com.maizi.domain.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author maizi
 * @description 针对表【t_account】的数据库操作Service
 * @createDate 2022-08-04 04:49:14
 */
public interface AccountService extends IService<Account> {


    boolean buy(Long userId, Long money);

}
