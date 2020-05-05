package com.zhaojm.springcloud;

import com.zhaojm.rule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author zhaojm
 * @date 2020/5/4 16:30
 */
@SpringBootApplication
@EnableEurekaClient
// 负载均衡使用自定义的
@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT", configuration = MyRibbonRule.class)
public class OrderRunApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderRunApp.class, args);
    }
}
