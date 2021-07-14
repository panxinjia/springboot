package com.xiaopantx.springboot.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author panxj
 */
@Service
public class ScheduleTaskService {

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("间隔5秒执行一次~");
    }

    @Scheduled(cron = "*/2 * * * * ?")
    public void fixTime() {
        // cron表达式
        System.out.println("2秒执行一次");
    }
}
