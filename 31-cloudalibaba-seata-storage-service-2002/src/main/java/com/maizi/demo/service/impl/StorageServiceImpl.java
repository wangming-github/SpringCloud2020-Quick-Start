package com.maizi.demo.service.impl;

import com.maizi.demo.mapper.StorageMapper;
import com.maizi.demo.service.StorageService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author maizi
 * @description 针对表【t_storage】的数据库操作Service实现
 * @createDate 2022-08-01 21:27:53
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {


    @Resource
    private StorageMapper storageMapper;

    /**
     * 扣减库存
     */
    @Override
    public boolean decrease(Long productId, Integer count) {
        log.info("Seata全局事务id=================>{}", RootContext.getXID());
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");
        return true;
    }

}




