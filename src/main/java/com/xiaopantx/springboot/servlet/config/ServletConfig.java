package com.xiaopantx.springboot.servlet.config;

import com.xiaopantx.springboot.servlet.MyListener;
import com.xiaopantx.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaopantx
 */
@Configuration
public class ServletConfig {

    /**
     * 直接扫描就可以实现, 声明时配置Bean,配置更灵活, 官网推荐的方式
     * @return 注册的ServletBean
     */
    @Bean
    public ServletRegistrationBean<MyServlet> servletServletRegistrationBean() {
        // urlMappings覆盖元素
        ServletRegistrationBean<MyServlet> registrationBean = new ServletRegistrationBean<>(new MyServlet());
        // 启动即创建Servlet实例
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<MyListener> listenerRegistrationBean() {
        return null;
    }
}
