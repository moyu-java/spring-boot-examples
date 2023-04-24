package com.junmoyu.example.logback.config.thread;

import com.junmoyu.example.logback.util.TraceIdUtils;
import lombok.NonNull;
import org.slf4j.MDC;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * ThreadPoolTaskExecutor mdc wrapper.
 *
 * @author 莫语
 * @date 2023/4/18
 */
public class ThreadPoolTaskExecutorMdcWrapper extends ThreadPoolTaskExecutor {

    @Override
    public void execute(@NonNull Runnable task) {
        super.execute(TraceIdUtils.wrap(task, MDC.getCopyOfContextMap()));
    }

    @NonNull
    @Override
    public <T> Future<T> submit(@NonNull Callable<T> task) {
        return super.submit(TraceIdUtils.wrap(task, MDC.getCopyOfContextMap()));
    }

    @NonNull
    @Override
    public Future<?> submit(@NonNull Runnable task) {
        return super.submit(TraceIdUtils.wrap(task, MDC.getCopyOfContextMap()));
    }

    @NonNull
    @Override
    public ListenableFuture<?> submitListenable(@NonNull Runnable task) {
        return super.submitListenable(TraceIdUtils.wrap(task, MDC.getCopyOfContextMap()));
    }

    @NonNull
    @Override
    public <T> ListenableFuture<T> submitListenable(@NonNull Callable<T> task) {
        return super.submitListenable(TraceIdUtils.wrap(task, MDC.getCopyOfContextMap()));
    }
}
