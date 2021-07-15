package com.xiaopantx.boot.spring.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @EnableAspectJAutoProxy 自动切面代理
 * @author xiaopantx
 */
@EnableAsync
@EnableScheduling
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAnnotationApplication.class, args);
    }

}
