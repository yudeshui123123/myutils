package com.common.myutils.config;

import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/9/7 9:41
 * @description:
 */
@Configuration
public class myConfig implements WebMvcConfigurer {


    /**
     * 添加视图跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/common.html").setViewName("/common/common");
        registry.addViewController("/dictionary.html").setViewName("/tool/dictionary");
    }

    /**
     * 给容器中注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}
