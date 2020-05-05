package com.zhaojm.springcloud.service.impl;

import com.zhaojm.springcloud.dao.PaymentDao;
import com.zhaojm.springcloud.entities.Payment;
import com.zhaojm.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhaojm
 * @date 2020/5/4 15:58
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
