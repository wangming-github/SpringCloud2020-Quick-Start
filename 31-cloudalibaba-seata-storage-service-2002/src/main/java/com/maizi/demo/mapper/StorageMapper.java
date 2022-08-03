package com.maizi.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author maizi
 * @description 针对表【t_storage】的数据库操作Mapper
 * @createDate 2022-08-01 21:27:53
 * @Entity com.maizi.demo.domain.Storage
 */
@Mapper
public interface StorageMapper {

    /**
     * 扣减库存
     *
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}




