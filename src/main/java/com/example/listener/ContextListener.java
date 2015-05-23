package com.example.listener;

import com.example.dao.DaoFactory;
import com.example.dao.DatabaseType;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

public class ContextListener implements ServletContextListener {

    DaoFactory daoFactory;
    /**
     * put DaoFactory in servlet context which will use for entire application
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        daoFactory = DaoFactory.getDaoFactory(DatabaseType.MYSQL);
        servletContext.setAttribute("daoFactory", daoFactory);
        System.out.println("context initialized");
    }

    /**
     * will be released all connections of connection pool which is common for entire application
     *
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("context destroyed");
    }
}
