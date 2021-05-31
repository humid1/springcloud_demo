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
