package com.maizi.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/3 02:15
 */
@MapperScan("com.maizi.demo.mapper")
@Configuration
public class MapperScanConfig {
}
