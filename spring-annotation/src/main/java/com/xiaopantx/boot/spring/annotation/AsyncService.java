package com.xiaopantx.boot.spring.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author panxj
 */
@Slf4j
@Service
public class AsyncService {

    @Async
    public void incre(Integer i) {
        System.out.println("i=" + i);
    }

    @Scheduled(fixedRate = 1000)
    public void fixedRate() {
        log.info("1秒间隔执行一次 ");
    }
}
