package com.zhaojm.springcloud.service.hystrix;

import com.zhaojm.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Component;

/**
 * @author zhaojm
 * @date 2020/5/5 16:26
 */
@Component
public class PaymentFeignServiceHystrix implements PaymentFeignService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "调用失败";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "调用失败";
    }
}
