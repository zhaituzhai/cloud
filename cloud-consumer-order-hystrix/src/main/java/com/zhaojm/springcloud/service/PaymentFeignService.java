package com.zhaojm.springcloud.service;

import com.zhaojm.springcloud.service.hystrix.PaymentFeignServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhaojm
 * @date 2020/5/5 15:35
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-HYSTRIX", fallback = PaymentFeignServiceHystrix.class)
public interface PaymentFeignService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id);

}
