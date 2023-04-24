package com.junmoyu.example.logback.service;

import com.junmoyu.example.logback.config.thread.ThreadPoolExecutorMdcWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * LogbackService
 *
 * @author 莫语
 * @date 2023/4/18
 */
@Slf4j
@Service
public class LogbackService {

    @Async
    public void threadLog() {
        log.info("使用线程池开启的子线程，日志信息包含 TraceID");
    }

    public void threadPoolLog() {
        // 自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutorMdcWrapper(8, 16, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));
        threadPoolExecutor.execute(() -> log.info("使用线程池 ThreadPoolExecutor 开启的子线程，日志信息包含 TraceID"));
        threadPoolExecutor.submit(() -> log.info("使用线程池 ThreadPoolExecutor 开启的子线程，日志信息包含 TraceID"));
    }
}
