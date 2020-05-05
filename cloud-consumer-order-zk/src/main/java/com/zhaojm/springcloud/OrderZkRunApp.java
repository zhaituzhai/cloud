package com.zhaojm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhaojm
 * @date 2020/5/5 0:08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkRunApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkRunApp.class, args);
    }
}
