package com.xiaopantx.boot.spring.annotation.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author panxj
 */
@Service
public class EventListenerService implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent event) {
        Object source = event.getSource();
        System.out.println("事件源：" + source.getClass().getName());
        System.out.println("接收到事件： " + event.getMsg());
    }
}
