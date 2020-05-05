package com.zhaojm.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhaojm
 * @date 2020/5/5 12:20
 */
@Component
public class MyLoadBalancer implements LoadBalancerSelf {

    private AtomicInteger service = new AtomicInteger(0);

    private final int getAndIncrement() {
        int current, next;
        do {
            current = this.service.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while(!this.service.compareAndSet(current, next));
        System.out.println("****next" + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {
        int index = getAndIncrement() % instances.size();
        return instances.get(index);
    }
}
