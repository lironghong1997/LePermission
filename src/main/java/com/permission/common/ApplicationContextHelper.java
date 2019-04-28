package com.permission.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @version:1.0.0
 * @author: lironghong
 * @date: 2019/4/21 21:04
 * @description: ApplicationContext获取上下文
 */
@Component("ApplicationContextHelper")
public class ApplicationContextHelper implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T popBean(Class<T> tClass) {
        if (context == null) {
            return null;
        }
        return context.getBean(tClass);
    }

    public static <T> T popBean(String name, Class<T> tClass) {
        if (context == null) {
            return null;
        }
        return context.getBean(name,tClass);
    }
}
