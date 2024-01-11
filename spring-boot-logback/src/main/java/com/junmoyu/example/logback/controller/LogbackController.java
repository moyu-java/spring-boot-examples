package com.junmoyu.example.logback.controller;

import com.junmoyu.example.logback.service.LogbackService;
import com.junmoyu.example.logback.util.TraceIdUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LogbackController
 *
 * @author 莫语
 */
@Slf4j
@RestController
@RequestMapping("log")
@RequiredArgsConstructor
public class LogbackController {

    private final LogbackService logbackService;

    @GetMapping("normal")
    public String normalLog(){
        log.error("错误信息");
        log.warn("警告信息");
        log.info("正常info信息");
        log.debug("调试信息");
        return "success";
    }

    @GetMapping("trace-id")
    public String traceIdTest(){
        log.info("包含 trace id 的消息");
        new Thread(() -> log.info("子线程不包含 trace id 的消息")).start();

        new Thread(TraceIdUtils.wrap(() -> log.info("子线程包含了 trace id 的消息"), MDC.getCopyOfContextMap())).start();

        // 测试 @Async 注解生成的子线程的 Trace ID 传递
        // @Async 使用的是 Spring 默认的线程池，
        logbackService.threadLog();

        // 线程池测试
        logbackService.threadPoolLog();
        return "success";
    }
}
