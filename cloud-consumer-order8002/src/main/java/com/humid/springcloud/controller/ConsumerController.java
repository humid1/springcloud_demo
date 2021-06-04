package com.humid.springcloud.controller;

import com.humid.springcloud.entities.CommonResult;
import com.humid.springcloud.entities.Payment;
import com.humid.springcloud.lb.LoadBabanceCustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author qiujianping
 * @date Created in 2021/4/28 14:39
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {

    // public static final String PAYMENT_URL = "http://127.0.0.1:8001/";
    public static final String PAYMENT_URL = "http://cloud-provider-service/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBabanceCustom loadBabanceCustom;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "payment/create", payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPayById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/getForEntity/{id}")
    public CommonResult getPayByForId(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult(444, "操作失败！");
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        if (instances == null || instances.size() == 0) {
            return null;
        }
        ServiceInstance instances1 = loadBabanceCustom.instances(instances);
        URI uri = instances1.getUri();
        return restTemplate.getForObject(uri + "payment/get/lb", String.class);
    }

    // ====================> zipkin+sleuth
    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject(PAYMENT_URL + "payment/zipkin", String.class);
        return result;
    }
}
