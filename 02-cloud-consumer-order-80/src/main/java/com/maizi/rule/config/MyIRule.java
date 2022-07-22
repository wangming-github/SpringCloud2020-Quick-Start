package com.maizi.rule.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置自定义远程调用规则：随机
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/22 09:13
 */

@Configuration
public class MyIRule {

    @Bean
    public IRule myRule() {
        /*
         * 随机
         */
        return new RandomRule();
    }
}
