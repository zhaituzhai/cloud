package com.zhaojm.springcloud.service;

import com.zhaojm.springcloud.entities.Payment;

/**
 * @author zhaojm
 * @date 2020/5/4 15:57
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
