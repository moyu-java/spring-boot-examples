package com.junmoyu.example.logback.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * trace id utils.
 *
 * @author 莫语
 * @date 2023/4/24
 */
public class TraceIdUtils {

    /**
     * MDC traceId 键值
     */
    public static final String MDC_TRACE_ID = "traceId";

    /**
     * HTTP header 头中的 trace_id 键值
     */
    public static final String HEADER_TRACE_ID = "trace_id";

    /**
     * set trace id to MDC.
     */
    public static void setTraceIdIfAbsent() {
        if (StringUtils.isBlank(MDC.get(MDC_TRACE_ID))) {
            setTraceId(null);
        }
    }

    /**
     * set trace id to MDC.
     *
     * @param traceId trace id
     */
    public static void setTraceId(String traceId) {
        traceId = StringUtils.isBlank(traceId) ? generateTraceId() : traceId;
        MDC.put(MDC_TRACE_ID, traceId);
    }

    /**
     * get trace id from MDC.
     *
     * @return trace id
     */
    public static String getTraceId() {
        String traceId = MDC.get(MDC_TRACE_ID);
        return StringUtils.isBlank(traceId) ? generateTraceId() : traceId;
    }

    /**
     * remove trace id from MDC.
     */
    public static void remove() {
        MDC.remove(MDC_TRACE_ID);
    }

    /**
     * generate trace id.
     *
     * @return trace id
     */
    public static String generateTraceId() {
        return UUID.randomUUID().toString();
    }

    /**
     * Callable 任务包装
     *
     * @param callable callable 任务
     * @param context  MDC 上下文 Map - MDC.getCopyOfContextMap()
     * @param <T>      callable 返回数据的范型
     * @return 包装后的 callable 任务
     */
    public static <T> Callable<T> wrap(final Callable<T> callable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setTraceIdIfAbsent();
            T var;
            try {
                var = callable.call();
            } finally {
                MDC.clear();
            }
            return var;
        };
    }

    /**
     * runnable 任务包装
     *
     * @param runnable runnable 任务
     * @param context  MDC 上下文 Map - MDC.getCopyOfContextMap()
     * @return 包装后的 runnable 任务
     */
    public static Runnable wrap(final Runnable runnable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setTraceIdIfAbsent();
            try {
                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }
}
