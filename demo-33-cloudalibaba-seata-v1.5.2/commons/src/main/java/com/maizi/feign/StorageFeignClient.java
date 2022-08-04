package com.maizi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/4 09:50
 */
@FeignClient("storage-serve-center")
public interface StorageFeignClient {


    /**
     * 消耗货物
     *
     * @param productId 货物id
     * @param count     数量
     * @return
     */
    @PostMapping("/take")
    boolean take(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
