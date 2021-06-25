# SpringCloud Study

+ 项目热部署  
添加pom文件
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>

<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <fork>true</fork>
                <addResources>true</addResources>
            </configuration>
        </plugin>
    </plugins>
</build>
```
## cloud-provider-payment8001 / 8010
模拟支付订单提供者服务  + 集群

## cloud-consumer-order8002
模拟支付订单消费者服务

## cloud-api-commons
公共调用模块

## cloud-eureka-server7001
eureka注册中心服务

## clouud-erueka-server7002
eureka集群注册中心2

## cloud-provider-payment8011 / cloud-consumerzk-order8003
整合 zookeeper

## cloud-providerconsul-payment8012 / cloud-consumerconsul-order8004
整合 consul

## cloud-consumer-feign-order8005
使用 openFeign 服务调用

## cloud-provider-hystrix-payment8001
使用 hystrix 快速搭建服务提供者

## cloud-consumer-feign-hystrix-order8002
使用 hystrix 内整合的 openfeign 使用的消费者

## cloud-consumer-hystrix-dashboard9001
hystrix-dashboard 服务熔断/降级，监控服务

## cloud-gateway-server9527
整合使用 SpringCloud Gateway

## cloud-config-center-3344
config 配置中心，使用bus消息总线(需添加RabbitMQ配置信息)，修改配置中心的配置可使用执行以下命令直接刷新
```shell
# 全局刷新
curl -X POST "http://localhost:3344/actuator/bus-refresh"
# 单个服务刷新追加 （服务名:端口号）
curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355"
```

## cloud-config-client-3355 / cloud-config-client-3356
config 客户端，读取配置中心的配置信息。

## cloud-stream-rabbitmq-provider8801
<a href="https://docs.spring.io/spring-cloud-stream/docs/current/reference/html/index.html" target="_blank">官网地址</a>  
前提：安装RabbitMQ  
服务为 stream 生产端

## cloud-stream-rabbitmq-consumer8802
服务为 stream 消费端

## nacos 服务注册发现、配置中心
<a href="https://nacos.io/zh-cn/" target="_blank">nacos 官网地址</a>
* cloudalibaba-provider-payment9001 整合SpringCloud Alibaba / nacos 服务提供者  
* cloudalibaba-consumer-nacos-order9051 nacos 服务消费者，测试负载均衡  

## sentinel 分布式流控/服务降级、熔断
<a href="https://github.com/alibaba/Sentinel/" target="_blank">sentinel 官方地址</a>
* cloudalibaba-sentinel-service8401 测试熔断降级  
* cloudalibaba-provider-payment9003 服务提供者  
* cloudalibaba-consumer-nacos-order9052 服务消费者，整合openFeign

## seata 分布式事务
<a href="http://seata.io/zh-cn/" target="_blank">seata 官网地址</a>  
* cloud-seata-order-service2001 订单服务  
* cloud-seata-storage-service2002 库存服务  
* cloud-seata-account-service2003 账户余额服务