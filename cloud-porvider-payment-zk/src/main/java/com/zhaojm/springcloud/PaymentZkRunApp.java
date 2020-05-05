package com.zhaojm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhaojm
 * @date 2020/5/4 23:45
 */
@SpringBootApplication
@EnableDiscoveryClient // 用于向consul 或zookeeper作为注册中心是注册服务
public class PaymentZkRunApp {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZkRunApp.class, args);
    }
}
