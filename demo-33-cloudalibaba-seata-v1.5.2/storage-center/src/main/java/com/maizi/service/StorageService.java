package com.maizi.service;

import com.maizi.domain.Storage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author maizi
 * @description 针对表【t_storage】的数据库操作Service
 * @createDate 2022-08-04 05:12:28
 */
public interface StorageService extends IService<Storage> {

    boolean take(Long productId, Integer count);
}
