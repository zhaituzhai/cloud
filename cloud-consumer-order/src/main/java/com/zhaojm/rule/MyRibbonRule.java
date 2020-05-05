package com.zhaojm.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 不能放置@ComponentScan可以扫描到的目录中
 * @author zhaojm
 * @date 2020/5/5 11:46
 */
@Configuration
public class MyRibbonRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
    /*
    负载均衡算法 ：
        rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标，每次服务器重启rest接口计数从1开始。





     */

}
