package com.xiaopantx.boot.spring.annotation.config;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.xiaopantx.boot.spring.annotation.AsyncService;
import com.xiaopantx.boot.spring.annotation.entity.Person;
import com.xiaopantx.boot.spring.annotation.event.DemoEvent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author panxj
 */
@Configuration
public class IocAnnotation implements CommandLineRunner,
        ApplicationContextAware, ApplicationEventPublisherAware, ApplicationEventPublisher {

    @Bean
    public Person person() {
        return Person.builder().id(1).name("tom").build();
    }

    @Bean
    public Person person2() {
        return Person.builder().id(2).name("jerry").build();
    }

    @Autowired
    private AsyncService asyncService;

    @Override
    public void run(String... args) throws Exception {

        for(int i = 1; i <= 100; i++) {
            asyncService.incre(i);
        }
//        String[] names = applicationContext.getBeanNamesForType(Person.class);
//        Arrays.stream(names)
//                .forEach(person -> {
//                    System.out.println(person);
//                });
//        applicationContext.publishEvent(new DemoEvent(this, "IocAnnotation CommandLineRunner run "));
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        // 注入事件发布器
        applicationEventPublisher.publishEvent(new DemoEvent(this));
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        System.out.println("事件发布功能");
    }

    @Override
    public void publishEvent(Object event) {

    }
}
