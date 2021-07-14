package com.xiaopantx.springboot.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author panxj
 */
@Service
public class AsyncTaskService {

    /**
     * 异步执行的任务 @Async 可以指定由那个任务线程池执行
     * @param i
     * @return
     * @throws InterruptedException
     */
    @Async(value = "asyncExecutor")
    public Integer incre(Integer i) throws InterruptedException {
        //TimeUnit.MILLISECONDS.sleep(10);
        //TODO 测试执行异步任务
        return i + 1;
    }
}
