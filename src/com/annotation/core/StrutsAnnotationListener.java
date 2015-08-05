package com.annotation.core;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author liufeihua
 * @date 2015年8月3日下午9:28:43
 * @version 1.0
 * 
 */
public class StrutsAnnotationListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext context = servletContextEvent.getServletContext();
		String pagePath = context.getInitParameter("annotation-config");

		String path = StrutsAnnotationListener.class.getClassLoader()
				.getResource("").getPath()
				+ pagePath.replace(".", "\\");
		List<AnnotationBean> list = ReadAnnotation.parseAnnotation(path);
		context.setAttribute("struts_annotation", list);

		System.out.println("信息:系统annotation已经加载完成!!");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

		System.out.println("信息:系统已注销!");
	}
}
