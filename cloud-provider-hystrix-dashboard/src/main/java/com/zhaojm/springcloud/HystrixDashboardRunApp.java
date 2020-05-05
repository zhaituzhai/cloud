package com.zhaojm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author zhaojm
 * @date 2020/5/5 21:14
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardRunApp {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardRunApp.class, args);
    }
}
