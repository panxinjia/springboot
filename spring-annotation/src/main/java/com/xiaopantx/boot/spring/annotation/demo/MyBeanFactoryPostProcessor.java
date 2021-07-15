package com.xiaopantx.boot.spring.annotation.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author panxj
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("bean context 修改~");
        Object person  = beanFactory.getBean("person");


        Class<?> aClass = person.getClass();
        System.out.println(aClass.getName());

    }
}
