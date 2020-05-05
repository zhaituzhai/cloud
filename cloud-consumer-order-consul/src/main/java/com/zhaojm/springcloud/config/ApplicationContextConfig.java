package com.zhaojm.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhaojm
 * @date 2020/5/4 16:36
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 提供了多种便捷访问远程Http服务的方法
     * 是一种简单便捷的访问restful服务模板类，是spirng提供的用于访问Rest服务的客户端模板工具集
     * @return
     */
    @Bean
    // 通过微服务名称调用
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
