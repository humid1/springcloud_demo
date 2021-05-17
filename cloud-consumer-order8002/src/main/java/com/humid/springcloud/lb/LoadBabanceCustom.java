package com.humid.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qiujianping
 * @date Created in 2021/5/14 18:17
 */
@Component
public class LoadBabanceCustom implements ILoadBalance{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;

        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*****第几次访问次数，next: " + next);
        return next;
    }


    /**
     * 默认负载轮训算法:
     *  rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标，
     *  每次服务重启动后rest接口计数从1开始。
     * @param instanceList
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> instanceList) {
        int index = getAndIncrement() % instanceList.size();
        return instanceList.get(index);
    }
}
