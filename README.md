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
## cloud-provider-payment8001
模拟支付订单提供者服务  

## cloud-consumer-order8002
模拟支付订单消费者服务

## cloud-api-commons
公共调用模块

## cloud-eureka-server7001
eureka注册中心服务

