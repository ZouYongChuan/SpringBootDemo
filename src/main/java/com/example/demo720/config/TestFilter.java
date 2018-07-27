package com.example.demo720.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Component
@WebFilter(filterName="TestFilter",urlPatterns="/**")
public class TestFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("==>过滤器销毁");
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String authToken = request.getHeader("Authorization");
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        System.out.println("过滤器正在执行...");
        chain.doFilter(req, resp);
    }
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("==>过滤器开始");
    }

}
