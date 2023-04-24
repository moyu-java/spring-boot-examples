package com.junmoyu.example.logback.service;

import com.junmoyu.example.logback.config.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * feign client
 *
 * @author 莫语
 * @date 2023/4/24
 */
@FeignClient(name = "default", url = "https://blog.junmoyu.com", path = "/api", configuration = FeignInterceptor.class)
public interface FeignService {
}
