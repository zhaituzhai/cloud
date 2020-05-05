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

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****port:{},插入结果：{}" , serverPort, result);

        if (result > 0)
            return new CommonResult<>(200, "success + port:" + serverPort, result);
        else
            return new CommonResult<>(444, "fail + port:" + serverPort, null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("*****port:{},插入结果：{}" , serverPort, result);

        if (null != result)
            return new CommonResult<>(200, "success + port:" + serverPort, result);
        else
            return new CommonResult<>(444, "fail + port:" + serverPort, null);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String ele : services) {
            log.info("****element:{}", ele);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance ele : instances) {
            log.info(ele.getServiceId()+"\t"+ele.getHost()+"\t" +ele.getPort()+"\t" + ele.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/uuid")
    public String getUuid() {
        return UUID.randomUUID().toString();
    }

    @GetMapping(value = "/payment/sleep")
    public String getUuidSleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("错误", e);
        }
        return UUID.randomUUID().toString();
    }
}
