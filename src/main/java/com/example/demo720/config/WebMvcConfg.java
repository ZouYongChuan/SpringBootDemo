package com.example.demo720.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfg implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**").excludePathPatterns("/hello/**");
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**");
    }
}