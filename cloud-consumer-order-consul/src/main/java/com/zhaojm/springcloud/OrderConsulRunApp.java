package com.zhaojm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhaojm
 * @date 2020/5/5 9:12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulRunApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulRunApp.class, args);
    }
}
