package com.zhaojm.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhaojm.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhaojm
 * @date 2020/5/5 15:37
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderController{
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/order/payment/hystrix/ok/{id}")
//    @HystrixCommand  // @fallback
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String result = paymentFeignService.paymentInfoOk(id);
        log.info("****result" + result);
        return result;
    }

    @GetMapping("order/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
//    @HystrixCommand
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        int age = 0/10;
        String result = paymentFeignService.paymentInfoTimeOut(id);
        log.info("****result" + result);
        return result;
    }

    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " 运行异常或超时，请稍后再试";
    }

    public String paymentGlobalFallbackMethod() {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
