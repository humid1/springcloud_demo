package com.humid.springcloud.filter;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiujianping
 * @date Created in 2021/5/31 14:52
 */
@Component
@Slf4j
public class MyGlobalGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***** come in MylogGatewayFilter: " + new Date() + "******");
        // 获取请求的参数名称
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (null == uname) {
            log.info("****** 用户名为 null，非法用户，o(╥﹏╥)o ******");
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.FORBIDDEN);
            // 生成json串
            Map<String, Object> maps = new HashMap<>();
            maps.put("code", HttpStatus.FORBIDDEN.value());
            maps.put("msg", HttpStatus.FORBIDDEN.getReasonPhrase());
            byte[] bytes = JSONUtil.toJsonStr(maps).getBytes(StandardCharsets.UTF_8);
            DataBuffer wrap = response.bufferFactory().wrap(bytes);
            // 设置响应头信息
            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
            return response.writeWith(Mono.just(wrap));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
