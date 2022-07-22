package com.maizi.springboot.controller;

import com.maizi.demo.entities.Payment;
import com.maizi.demo.module.R;
import com.maizi.springboot.config.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/20 02:29
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001";

    public static final String PAYMENT_URL = "http://01-CLOUD-PROVIDER-PAYMENT-SERVICE";

    @Resource
    RestTemplate restTemplate;


    /**
     * 添加
     *
     * @param payment
     * @return
     */
    @GetMapping("/payment/save")
    public R create(Payment payment) {
        log.info("======>Payment:{}", payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, R.class);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/{id}")
    public R find(@PathVariable("id") Long id) {
        log.info("======>id:{}", id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, R.class);
    }


    /**
     * 查询
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/getForEntity/{id}")
    public R findReturnEntity(@PathVariable("id") Long id) {
        final ResponseEntity<R> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/" + id, R.class);

        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new R<>(444, "请求失败！！！");
        }
    }


    @Resource
    private MyLoadBalancer myLoadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("01-CLOUD-PROVIDER-PAYMENT-SERVICE");

        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = myLoadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);

    }

}
