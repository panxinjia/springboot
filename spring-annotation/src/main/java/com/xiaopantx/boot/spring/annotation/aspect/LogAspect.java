package com.xiaopantx.boot.spring.annotation.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author panxj
 */
//@Component
//@Aspect
public class LogAspect {

    /**
     * 定义切点， 基于方法拦截
     */
    @Pointcut("execution(* *.*.*(..))")
    public void pointCut() {

    };

    /**
     * 基于注解拦截
     */
    @Pointcut("@annotation(com.xiaopantx.boot.spring.annotation.aspect.MyAnnotation)")
    public void annotation() {

    }

    @Around("annotation()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {

        try {
            // 前置
            Object result = proceedingJoinPoint.proceed();
            // 后置
        }catch (Throwable e) {
            // 异常
        }finally {

        }
    }

    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        // 前置通知
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String sessionId = attributes.getSessionId();
    }

    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        // 后置通知
    }

    @AfterReturning(returning = "ret", pointcut = "pointCut()")
    public void afterReturningMethod(Object ret, Joinpoint joinpoint) {
        // 返回通知
    }

    @AfterThrowing(throwing = "ex", pointcut = "pointCut()")
    public void afterThrowingMethod(Throwable  ex, JoinPoint joinPoint) {
        // 异常通知
    }
}


