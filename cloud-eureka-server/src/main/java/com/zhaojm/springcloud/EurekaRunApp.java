package com.zhaojm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhaojm
 * @date 2020/5/4 18:17
 */
@SpringBootApplication
// 表示 eureka 服务端
@EnableEurekaServer
public class EurekaRunApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaRunApp.class, args);
    }
}
