package com.example.demo720.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
    @Around(value = "execution(* com.example.demo720.controller.*.*(..))")
    public Object handleControllerMethod (ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        System.out.println("Aspect Start");
        Object[] args=proceedingJoinPoint.getArgs();
        for(Object arg:args){
            System.out.println("Aspect:arg is "+arg);
        }
        Object object= proceedingJoinPoint.proceed();
        System.out.println("Aspect end");
        return object;
    }




}
