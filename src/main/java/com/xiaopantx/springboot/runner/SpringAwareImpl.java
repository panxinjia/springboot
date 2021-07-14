package com.xiaopantx.springboot.runner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;

/**
 * Spring提供的Aware接口的子接口， 用来强化Bean的功能，使用Spring的一些高级功能
 * @author panxj
 */
public class SpringAwareImpl implements EnvironmentAware,
        ApplicationContextAware,
        BeanNameAware,
        BeanFactoryAware,
        MessageSourceAware,
        ApplicationEventPublisherAware,
        ResourceLoaderAware
{

    private Environment environment;
    private ApplicationContext applicationContext;
    @Override
    public void setEnvironment(Environment environment) {
        // 注入 Spring应用环境 Environment
        this.environment = environment;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 注入应用上下文
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // 注入当前bean的 BeanFactory
    }

    @Override
    public void setBeanName(String name) {
        // 当前Bean名称
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
        // 事件发布器
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        // 文本信息
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        // Spring的资源加载器， 加载外部资源
    }
}
