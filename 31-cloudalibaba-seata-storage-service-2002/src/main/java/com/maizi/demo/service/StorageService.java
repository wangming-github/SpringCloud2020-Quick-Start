package com.maizi.demo.service;

/**
* @author maizi
* @description 针对表【t_storage】的数据库操作Service
* @createDate 2022-08-01 21:27:53
*/
public interface StorageService  {

    boolean decrease(Long productId, Integer count);
}
