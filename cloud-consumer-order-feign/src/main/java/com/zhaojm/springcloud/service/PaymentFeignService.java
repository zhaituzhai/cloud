package com.zhaojm.springcloud.service;

import com.zhaojm.springcloud.entities.CommonResult;
import com.zhaojm.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhaojm
 * @date 2020/5/5 13:08
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/sleep")
    String getUuidSleep();
}
