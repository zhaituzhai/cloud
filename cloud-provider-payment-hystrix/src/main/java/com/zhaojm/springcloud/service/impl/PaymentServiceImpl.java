package com.zhaojm.springcloud.service.impl;

import ch.qos.logback.core.util.TimeUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhaojm.springcloud.service.IPaymentService;
import io.micrometer.core.instrument.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaojm
 * @date 2020/5/5 15:01
 */
@Service
@Slf4j
public class PaymentServiceImpl implements IPaymentService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " paymentInfoOk,id: " + id +"is OK o(n_n)o";
    }

    @Override
    // 超时峰值上限与对应处理方法
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeOut(Integer id) {
        // 运行异常
        int age = 10/0;
        // 超时异常
        int timeNum = 0;
//        try {
//            TimeUnit.SECONDS.sleep(timeNum);
//        } catch (InterruptedException e) {
//            log.error("错误", e);
//        }
        return "线程池： " + Thread.currentThread().getName() + " paymentInfoOk,id: " + id +"is OK o(n_n)o  耗时(s) " + timeNum;
    }

    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " 运行异常或超时，请稍后再试";
    }
    // 服务熔断 熔断或过了10s（时间窗口期）才慢慢恢复正常
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启短路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败率达到多少跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if(id < 0) {
            throw new RuntimeException("****id，不能为复数");
        }
        return Thread.currentThread().getName() + "\t" + UUID.randomUUID();
    }

    public String paymentCircuitBreakerFallback(Integer id) {
        return "****id，不能为复数,/(ㄒoㄒ)/~~ id + " + id;
    }
}
