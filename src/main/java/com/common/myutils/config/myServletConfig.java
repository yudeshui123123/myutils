package com.common.myutils.config;

import com.common.myutils.filter.MyFilter;
import com.common.myutils.listener.MyListener;
import com.common.myutils.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/9/15 17:04
 * @description:
 */
@Configuration
public class myServletConfig {

    /**
     * 注册Servlet组件
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {

        return new ServletRegistrationBean(new MyServlet(), "/myServlet");
    }

    /**
     * 过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/myServlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyListener());
        return servletListenerRegistrationBean;
    }
}
