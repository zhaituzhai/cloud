package com.zhaojm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author zhaojm
 * @date 2020/5/6 21:55
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigRunAPP {
    public static void main(String[] args) {
        SpringApplication.run(ConfigRunAPP.class, args);
    }
}
