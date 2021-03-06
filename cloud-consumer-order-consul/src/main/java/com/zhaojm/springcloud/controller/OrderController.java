package com.zhaojm.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhaojm
 * @date 2020/5/5 0:09
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://cloud-provider-payment-consul";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/order/consul/uuid")
    public String getUuid() {
        return restTemplate.getForObject(PAYMENT_URL + "consul/uuid", String.class);
    }

}
