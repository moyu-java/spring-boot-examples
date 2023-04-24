package com.junmoyu.example.logback.config;

import com.junmoyu.example.logback.util.TraceIdUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * feign 拦截器，设置 Trace Id 透传
 *
 * @author 莫语
 * @date 2023/4/24
 */
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        template.header(TraceIdUtils.HEADER_TRACE_ID, TraceIdUtils.getTraceId());
    }
}
