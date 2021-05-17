package com.humid.springcloud.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.humid.springcloud.entities.CommonResult;
import com.humid.springcloud.entities.Payment;
import com.humid.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qiujianping
 * @date Created in 2021/4/28 14:39
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("插入结果是:{}", i);
        if (i > 0) {
            return new CommonResult(200, "插入数据成功！server-port:" + serverPort, i);
        } else {
            return new CommonResult(500, "插入数据失败！server-port:" + serverPort);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null == payment) {
            return new CommonResult(519, "没有对应记录，server-port:" + serverPort);
        }
        return new CommonResult(200, "查询成功,server-port:" + serverPort, payment);
    }

    @GetMapping("/get/lb")
    public String getLb() {
        return serverPort;
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Object getObject() {
        // 获取服务发现中的服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*********** elment: {} *************", service);
        }
        // 获取改微服务的具体信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("********* {} **** {} **** {} ******* {} **********", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }
        return instances;
    }
}
