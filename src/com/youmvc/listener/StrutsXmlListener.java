package com.youmvc.listener;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.youmvc.model.XmlBean;
import com.youmvc.util.StrutsXml;

/**
 * @author liufeihua
 * @date 2015年7月21日
 * @version 1.0
 * 
 */
public class StrutsXmlListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext context = servletContextEvent.getServletContext();
		String xmlPath = context.getInitParameter("struts-config");
		String tomcatPath = context.getRealPath("\\");

		String newPath = tomcatPath + xmlPath;

		// String newPath= path.replace("\\","\\\\");

		Map<String, XmlBean> xmlBeanMap = StrutsXml.parseXml(newPath);
		context.setAttribute("struts", xmlBeanMap);

		System.out.println("信息:系统已经加载完成!!");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

		System.out.println("信息:系统已注销!");
	}
}
