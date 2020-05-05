package com.zhaojm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhaojm
 * @date 2020/5/5 13:06
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignRunApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignRunApp.class, args);
    }
}
