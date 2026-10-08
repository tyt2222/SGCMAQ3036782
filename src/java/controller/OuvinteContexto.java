/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package controller;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import framework.config.AppConfig;
import framework.log.ExceptionLogTrack;
import framework.dao.DataBaseConnections;

public class OuvinteContexto implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        AppConfig.getInstance();
        ExceptionLogTrack.getInstance();
        DataBaseConnections.getInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            DataBaseConnections.getInstance().closeAllConnections();
        } catch (Exception ex) {
            ExceptionLogTrack.getInstance().addLog(ex);
        }
    }
}
