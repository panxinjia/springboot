package com.xiaopantx.springboot.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author xiaopantx
 */
@WebFilter(urlPatterns = {"/*"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // servlet filter 责任链设计模式
        // 前处理
        System.out.println("MyFilter do filter");
        chain.doFilter(request, response);
        // 后处理

    }

    @Override
    public void destroy() {
        System.out.println("MyFilter destory ");
    }
}
