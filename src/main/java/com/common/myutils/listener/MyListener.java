package com.common.myutils.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/9/15 21:00
 * @description:
 */
public class MyListener implements ServletContextListener {

    /**
     * servlet初始化时执行
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("servlet启动了！");
    }

    /**
     * 当servlet停止或当前项目被移除是执行
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servlet销毁了！");
    }
}
