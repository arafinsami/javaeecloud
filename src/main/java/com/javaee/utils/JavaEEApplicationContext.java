package com.javaee.utils;

import jakarta.servlet.ServletContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class JavaEEApplicationContext {

    public static <T> T getBean(ServletContext servletContext, Class<T> clazz, String beanName) {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        return context.getBean(clazz, beanName);
    }
}