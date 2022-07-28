package com.maizi.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

/**
 * 代码中注入RouteLocator的Bean
 *
 * @author maizi
 */
@Configuration
public class GateWayConfig {


    /**
     * 配置了一个id为 path_route_maizi 的路由规则，
     * 当访问地址 http://localhost:9527/guonei时会自动转发到地址：http://news.baidu.com/guonei
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        //路由构建器
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_maizi", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }


    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now());
    }
}