package com.xiaopantx.springboot.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @EnableAsync 开启Spring对异步任务的支持
 *
 * @author panxj
 */
@Configuration
public class TaskExecutorConfig {
        // implements AsyncConfigurer {

    // @Override
    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(5);
        // 最大线程数
        executor.setMaxPoolSize(10);
        // 任务队列可以保存任务数量
        executor.setQueueCapacity(25);
        // 拒绝策略
        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                // TODO 拒绝策略
            }
        });
        // 线程池初始化
        executor.initialize();
        return executor;
    }
//
//    @Override
//    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
//        // 捕获异步任务异常
//        System.out.println("捕获异步任务抛出的异常~");
//        return new SimpleAsyncUncaughtExceptionHandler();
//    }
}
