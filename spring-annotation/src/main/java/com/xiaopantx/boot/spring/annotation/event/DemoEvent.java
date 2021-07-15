package com.xiaopantx.boot.spring.annotation.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 *
 * @author panxj
 */
@Data
public class DemoEvent extends ApplicationEvent {
    private String msg;
    public DemoEvent(Object source) {
        super(source);
    }

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public DemoEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
