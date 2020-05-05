package com.zhaojm.springcloud.controller;

import com.zhaojm.springcloud.entities.CommonResult;
import com.zhaojm.springcloud.entities.Payment;
import com.zhaojm.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhaojm
 * @date 2020/5/5 13:14
 */
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/feign/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/payment/sleep")
    public String getUuidSleep() {
        return paymentFeignService.getUuidSleep();
    }

}
