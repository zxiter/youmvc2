package com.youmvc.listener;

import com.youmvc.model.XmlBean;
import com.youmvc.util.StrutsXml;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;

/**
 * Created by liufh on 2015/7/21.
 */
public class StrutsXmlListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context=servletContextEvent.getServletContext();
        String xmlPath=context.getInitParameter("struts-config");
        String tomcatPath=context.getRealPath("\\");

        String newPath=tomcatPath+xmlPath;

      //  String newPath= path.replace("\\","\\\\");

        Map<String,XmlBean> xmlBeanMap= StrutsXml.parseXml(newPath);
        context.setAttribute("struts",xmlBeanMap);

        System.out.println("信息:系统已经加载完成!!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        System.out.println("信息:系统已注销!");
    }
}
