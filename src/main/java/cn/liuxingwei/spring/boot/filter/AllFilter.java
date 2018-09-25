package cn.liuxingwei.spring.boot.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AllFilter", urlPatterns = "/user/add")
public class AllFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("----AllFilter----");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
