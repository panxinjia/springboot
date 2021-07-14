package com.xiaopantx.springboot.servlet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author panxj
 */
//@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 扩展资源映射
        // registry.addResourceHandler("");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 配置跨域
        // registry.addMapping("/**");
    }
}
