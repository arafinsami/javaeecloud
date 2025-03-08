package com.javaee.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class ApplicationStartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        ServletRegistration defaultServlet = context.getServletRegistration("default");
        if (defaultServlet != null) {
            defaultServlet.addMapping("/resources/*");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("ServletContext is being destroyed !!!");
    }
}
