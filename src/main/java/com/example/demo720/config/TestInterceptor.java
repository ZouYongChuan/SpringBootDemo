package com.example.demo720.config;

import org.springframework.core.MethodParameter;
import org.springframework.messaging.handler.HandlerMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TestInterceptor extends HandlerInterceptorAdapter {
    private UrlPathHelper urlPathHelper = new UrlPathHelper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws  Exception{
        String url = urlPathHelper.getLookupPathForRequest(request);

        String queryString = urlPathHelper.getOriginatingQueryString(request);
        //if (!(queryString==null||queryString.length()<=0)) {
        //    redirectURL = redirectURL + "?" + queryString;
        //    response.sendRedirect(request.getContextPath() + "/Login1.html");
        //    return true;
        //}
        String authToken = request.getHeader("Authorization");
        System.out.println("Interceptor::"+authToken);
        System.out.println("Interceptor:"+url);
        System.out.println("Interceptor:"+queryString);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Timeinterceptor postHandle");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Timeinterceptor afterCompletion");
        super.afterCompletion(request, response, handler, ex);
    }
}
