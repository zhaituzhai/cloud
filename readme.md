spring cloud 基础知识学习

1. 基础服务
    payment 支付的基本微服务：cloud-provider-payment  
    8001，8002变更端口可开启多个微服务,充当生产者  
    order 订单微服务：cloud-comsumer-order  
    8101，使用RPC调用Payment服务。充当消费者  

2. 服务注册与使用  
    1. Eureka - cloud-provider-payment/cloud-comsumer-order
    2. Zookeeper  -  cloud-provider-payment-zk/cloud-comsumer-order-zk
    3. consulcloud - provider-payment-consul/cloud-comsumer-order-consul

3. 负载均衡
    1. Ribbon - 默认IRule  
                自定义Rule - MyRibbonRule  
    2. 手写一个自定义负载均衡规则  

4. 服务调用  
    1. feign  
    2. open feign：cloud-consumer-order-feign  
        ribbon: 默认超时时间 1s 设置  
        日志：Logger.Level.FULL  

5. 服务降级  
    1. Hystrix  
        降级，熔断，限流  
        兜底的处理方法(出现异常，或超过设置处理时间)  
        给feign配置统一的处理类  

6. 服务网关  
    1. zuul  
    2. gateway cloud-gateway  
        配置文件  
        bean  
        负载均衡  
        