package com.zhaojm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhaojm
 * @date 2020/5/4 12:47
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentRunApp {
    public static void main(String[] args) {
        SpringApplication.run(PaymentRunApp.class, args);
    }
}
