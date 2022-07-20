package com.maizi.demo.controller;

import com.maizi.demo.entities.Payment;
import com.maizi.demo.module.R;
import com.maizi.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/20 01:05
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPost;

    @PostMapping(value = "/payment/save")
    public R create(@RequestBody Payment payment) {
        log.info("======>Payment : " + payment);

        if (paymentService.save(payment)) {
            return new R(200, "成功！" + serverPost, true);
        } else {
            return new R(444, "失败！" + serverPost, false);
        }
    }


    @GetMapping(value = "/payment/{id}")
    public R getById(@PathVariable("id") Long id) {
        final Payment payment = paymentService.getById(id);
        log.info("======>Payment find: " + payment);
        if (payment != null) {
            return new R(200, "成功！" + serverPost, payment);
        } else {
            return new R(444, "失败！" + serverPost);
        }
    }


    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping(value = "/payment/discovery")
    public Object discovery() {

        //获取微服务名称
        final List<String> services = discoveryClient.getServices();
        services.forEach(service -> log.info("======>Service: " + service));

        //获取微服务的实例
        final List<ServiceInstance> instances = discoveryClient.getInstances("01-CLOUD-PROVIDER-PAYMENT-SERVICE");
        instances.forEach(instance -> log.info("======>Instance: " + instance.getServiceId() +
                "\t" + instance.getHost() +
                "\t" + instance.getPort() +
                "\t" + instance.getUri()));

        return this.discoveryClient;
    }

}
