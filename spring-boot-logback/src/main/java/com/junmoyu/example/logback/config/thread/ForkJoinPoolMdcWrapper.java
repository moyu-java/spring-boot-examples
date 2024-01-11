package com.junmoyu.example.logback.config.thread;

import com.junmoyu.example.logback.util.TraceIdUtils;
import org.slf4j.MDC;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * ForkJoinPool mdc wrapper.
 *
 * @author 莫语
 */
public class ForkJoinPoolMdcWrapper extends ForkJoinPool {


    public ForkJoinPoolMdcWrapper(int parallelism) {
        super(parallelism);
    }

    public ForkJoinPoolMdcWrapper(int parallelism,
                                  ForkJoinWorkerThreadFactory factory,
                                  Thread.UncaughtExceptionHandler handler,
                                  boolean asyncMode) {
        super(parallelism, factory, handler, asyncMode);
    }

    @Override
    public void execute(Runnable task) {
        super.execute(TraceIdUtils.wrap(task, MDC.getCopyOfContextMap()));
    }

    @Override
    public ForkJoinTask<?> submit(Runnable task) {
        return super.submit(TraceIdUtils.wrap(task, MDC.getCopyOfContextMap()));
    }

    @Override
    public <T> ForkJoinTask<T> submit(Runnable task, T result) {
        return super.submit(TraceIdUtils.wrap(task, MDC.getCopyOfContextMap()), result);
    }

    @Override
    public <T> ForkJoinTask<T> submit(Callable<T> task) {
        return super.submit(TraceIdUtils.wrap(task, MDC.getCopyOfContextMap()));
    }
}
