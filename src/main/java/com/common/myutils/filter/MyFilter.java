package com.common.myutils.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/9/15 17:42
 * @description:
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("好吧！！！");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
