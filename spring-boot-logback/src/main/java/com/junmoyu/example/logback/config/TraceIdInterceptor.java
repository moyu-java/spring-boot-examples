package com.junmoyu.example.logback.config;

import com.junmoyu.example.logback.util.TraceIdUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;


/**
 * trace id 拦截器
 *
 * @author 莫语
 * @date 2023/4/24
 */
@Slf4j
public class TraceIdInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        // 从请求头中获取 traceId
        String traceId = request.getHeader(TraceIdUtils.HEADER_TRACE_ID);
        // 将 traceId 设置到 MDC 中，如果传入的 traceId 为空则自动生成。
        TraceIdUtils.setTraceId(traceId);
        // 将 traceId 设置到响应头中
        response.setHeader(TraceIdUtils.HEADER_TRACE_ID, TraceIdUtils.getTraceId());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) throws Exception {
        // 接口返回时，清除 MDC 中的 traceId，避免内存泄漏或上下文信息错误传递的问题。
        TraceIdUtils.remove();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
