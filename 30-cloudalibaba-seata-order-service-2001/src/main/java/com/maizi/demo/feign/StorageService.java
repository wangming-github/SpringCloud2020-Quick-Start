package com.maizi.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 远程调用库存服务
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/1 06:34
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 减库存 post请求
     *
     * @param productId 商品Id
     * @param count     库存总数
     * @return 执行结果
     */
    @PostMapping("/storage/decrease")
    boolean decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);


}
