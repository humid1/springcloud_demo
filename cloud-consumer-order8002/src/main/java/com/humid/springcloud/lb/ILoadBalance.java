package com.humid.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author qiujianping
 * @date Created in 2021/5/14 18:08
 */
public interface ILoadBalance {
    ServiceInstance instances(List <ServiceInstance> instanceList);
}
