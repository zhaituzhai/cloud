package com.zhaojm.springcloud.controller;

import com.zhaojm.springcloud.entities.CommonResult;
import com.zhaojm.springcloud.entities.Payment;
import com.zhaojm.springcloud.lb.LoadBalancerSelf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author zhaojm
 * @date 2020/5/4 16:32
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://127.0.0.1:8001";
    /*
        修改为名称调用
        需要添加负载均衡
     */
    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancerSelf loadBalancerSelf;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/getSelf/{id}")
    public CommonResult<Payment> getPaymentSelf(@PathVariable("id") Long id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        if(null == instances || instances.size() <= 0) {
            log.error("为获取启动服务列表");
            return null;
        }
        ServiceInstance serviceInstance = loadBalancerSelf.instance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/get/" + id, CommonResult.class);
    }

}
