package cn.hniu.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *  监听获取项目名
 */
public class ProjectNameList implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        String projectPath = application.getContextPath();
        logger.info("项目名称：" + projectPath);
        application.setAttribute("APP_PATH", projectPath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
