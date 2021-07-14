package com.xiaopantx.springboot.servlet.config;

import com.xiaopantx.springboot.servlet.*;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import java.util.Arrays;

/**
 * @author xiaopantx
 */
//@Configuration
public class ServletConfig {

    /**
     * 声明注册Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean<MyServlet> servletServletRegistrationBean() {
        // urlMappings覆盖元素
        ServletRegistrationBean<MyServlet> registrationBean = new ServletRegistrationBean<>(new MyServlet());
        // 启动即创建Servlet实例
        registrationBean.setLoadOnStartup(1);
        registrationBean.setUrlMappings(Arrays.asList(
                "/srv"
        ));
        return registrationBean;
    }

    /**
     * 声明注册监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<MyListener> listenerRegistrationBean() {
        ServletListenerRegistrationBean<MyListener> listenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        listenerRegistrationBean.setEnabled(true);
        listenerRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return listenerRegistrationBean;
    }

    /**
     * 声明注册过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean<MyFilter> filterFilterRegistrationBean() {
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList(
                "/*"
        ));
        return filterRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean<AFilter> filterFilterRegistrationBeanA() {
        FilterRegistrationBean<AFilter> filterRegistrationBean = new FilterRegistrationBean<>(new AFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList(
                "/*"
        ));
        return filterRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean<BFilter> filterFilterRegistrationBeanB() {
        FilterRegistrationBean<BFilter> filterRegistrationBean = new FilterRegistrationBean<>(new BFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList(
                "/*"
        ));
        return filterRegistrationBean;
    }

}
