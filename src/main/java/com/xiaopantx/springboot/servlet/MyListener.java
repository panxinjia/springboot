package com.xiaopantx.springboot.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session监听器
 * @author xiaopantx
 */
@WebListener
public class MyListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // session 创建
        System.out.println("session 创建:" + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // session 销毁
        System.out.println("session 销毁:" + se.getSession().getId());
    }
}
