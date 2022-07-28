package com.maizi.demo.Filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/26 03:01
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    /**
     * 所有请求必须带着“uname”参数
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("=========> come in MyLogGateWayFilter:  " + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null) {
            log.info("=========>用户名为null，非法用户，o(╥﹏╥)o");
            //返回状态码：不被接受  NOT_ACCEPTABLE(406, "Not Acceptable"),
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 优先加载此过滤器
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
