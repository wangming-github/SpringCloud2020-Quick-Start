package com.maizi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maizi.domain.Storage;
import com.maizi.modle.MyLog;
import com.maizi.service.StorageService;
import com.maizi.mapper.StorageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author maizi
 * @description 针对表【t_storage】的数据库操作Service实现
 * @createDate 2022-08-04 05:12:28
 */
@Slf4j
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Override
    public boolean take(Long productId, Integer count) {
        return updateStorage(productId, count);
    }


    private boolean updateStorage(Long productId, Integer count) {
        final Storage one = getOne(new LambdaQueryWrapper<Storage>().eq(Storage::getProductId, productId));
        MyLog.info("updateStorage:" + one);
        return update(new LambdaUpdateWrapper<Storage>()
                .eq(Storage::getProductId, one.getProductId())
                .set(Storage::getUsed, one.getUsed() + count)
                .set(Storage::getResidue, one.getResidue() - count));
    }

}




