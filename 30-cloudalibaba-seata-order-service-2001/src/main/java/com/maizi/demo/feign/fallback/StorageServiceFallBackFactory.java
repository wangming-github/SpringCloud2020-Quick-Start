package com.maizi.demo.feign.fallback;

import com.maizi.demo.feign.StorageService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/1 09:23
 */
@Slf4j
@Component
public class StorageServiceFallBackFactory implements FallbackFactory<StorageService> {
    @Override
    public StorageService create(Throwable throwable) {
        return new StorageService() {
            /**
             * 减库存 post请求
             *
             * @param productId 商品Id
             * @param count     库存总数
             * @return 执行结果
             */
            @Override
            public boolean decrease(Long productId, Integer count) {
                log.error("远程调用 减库存模块productId:{},count:{} 失败:{}", productId, count, throwable.getMessage());
                return false;
            }
        };
    }
}
