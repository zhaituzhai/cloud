package com.zhaojm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhaojm
 * @date 2020/5/5 21:22
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayRunApp {
    public static void main(String[] args) {
        SpringApplication.run(GatewayRunApp.class, args);
    }
}
