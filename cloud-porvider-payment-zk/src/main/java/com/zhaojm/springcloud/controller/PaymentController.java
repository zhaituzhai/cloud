package com.zhaojm.springcloud.controller;

import com.zhaojm.springcloud.entities.CommonResult;
import com.zhaojm.springcloud.entities.Payment;
import com.zhaojm.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author zhaojm
 * @date 2020/5/4 16:01
 */
@RequestMapping
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "zk/uuid")
    public String getUuid() {
        return UUID.randomUUID().toString();
    }
}
