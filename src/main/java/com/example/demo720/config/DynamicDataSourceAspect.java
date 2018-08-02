package com.example.demo720.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
/**
 * 自定义注解 + AOP的方式实现数据源动态切换。
 * Created by pure on 2018-05-06.
 */
@Aspect
@Component
public class DynamicDataSourceAspect{
    @Before("@annotation(DS)")
    public void beforeSwitchDS(JoinPoint point){
        Class<?>className=point.getTarget().getClass();
        String methodName=point.getSignature().getName();
        Class[]argClass=((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSource=DataSourceContextHolder.DEFAULT_DS;
        try {
            Method method=className.getMethod(methodName,argClass);
            if(method.isAnnotationPresent(DS.class)){
                DS annotation=method.getAnnotation(DS.class);
                dataSource=annotation.value();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        DataSourceContextHolder.setDB(dataSource);
    }
    @After("@annotation(DS)")
    public void afterSwitchDS(JoinPoint point){
        DataSourceContextHolder.clearDB();
    }
}
