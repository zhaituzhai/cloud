package com.zhaojm.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义负载均衡算法
 * 步骤
 *  1、
 * @author zhaojm
 * @date 2020/5/5 12:17
 */
public interface LoadBalancerSelf {

    ServiceInstance instance(List<ServiceInstance> instances);

}
