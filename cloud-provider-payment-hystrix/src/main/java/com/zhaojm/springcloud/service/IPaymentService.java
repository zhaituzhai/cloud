package com.zhaojm.springcloud.service;

/**
 * @author zhaojm
 * @date 2020/5/5 15:00
 */
public interface IPaymentService {

    String paymentInfoOk(Integer id);

    String paymentInfoTimeOut(Integer id);

    String paymentCircuitBreaker(Integer id);

}
