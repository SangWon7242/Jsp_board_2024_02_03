package com.sbs.jsp.board.listener;

import com.sbs.jsp.board.app.App;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    App.init();
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {

  }
}
