package com.zhaojm.rule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Configuration;

/**
 * 不能放置@ComponentScan可以扫描到的目录中
 * @author zhaojm
 * @date 2020/5/5 11:06
 */
@Configuration
public class MyRule {

    public IRule myRule() {
        return new RandomRule();
    }

}
