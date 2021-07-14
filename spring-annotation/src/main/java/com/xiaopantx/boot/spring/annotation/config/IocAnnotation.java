package com.xiaopantx.boot.spring.annotation.config;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.xiaopantx.boot.spring.annotation.entity.Person;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author panxj
 */
@Configuration
public class IocAnnotation implements CommandLineRunner, ApplicationContextAware {

    @Bean(value = "beanName", initMethod = "initMethod", destroyMethod = "destoryMethod")
    public Person person() {
        return Person.builder().id(1).name("tom").build();
    }

    @Bean
    public Person person2() {
        return Person.builder().id(2).name("jerry").build();
    }

    @Override
    public void run(String... args) throws Exception {
        String[] names = applicationContext.getBeanNamesForType(Person.class);
        Arrays.stream(names)
                .forEach(person -> {
                    System.out.println(person);
                });
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
