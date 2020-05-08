package com.zhaojm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhaojm
 * @date 2020/5/6 22:20
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientRunApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientRunApp.class, args);
    }
}
