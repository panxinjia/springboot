package com.xiaopantx.springboot.runner;

import com.xiaopantx.springboot.async.AsyncTaskService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * @author panxj
 */
@Component
public class LoadRunner implements CommandLineRunner{

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Override
    public void run(String... args) throws Exception {
        // springboot 启动执行 commandLineRunner接口的run方法
        for(int i = 1; i < 10; i++) {
            asyncTaskService.incre(i);
        }
    }


}
