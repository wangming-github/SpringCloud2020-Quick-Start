package com.maizi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maizi.domain.Account;
import com.maizi.modle.MyLog;
import com.maizi.service.AccountService;
import com.maizi.mapper.AccountMapper;
import org.springframework.stereotype.Service;

/**
 * @author maizi
 * @description 针对表【t_account】的数据库操作Service实现
 * @createDate 2022-08-04 04:49:14
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Override
    public boolean buy(Long userId, Long money) {
        return updateAccount(userId, money);
    }


    private boolean updateAccount(Long userId, Long money) {

        final Account one = getOne(new LambdaQueryWrapper<Account>().eq(Account::getUserId, userId));
        MyLog.info("updateAccount:" + one);
        return update(new LambdaUpdateWrapper<Account>()
                .eq(Account::getUserId, one.getUserId())
                .set(Account::getUsed, one.getUsed() + money)
                .set(Account::getResidue, one.getResidue() - money));

    }
}




