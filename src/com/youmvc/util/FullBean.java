package com.youmvc.util;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

import com.youmvc.model.ActionForm;

/**
 * Created by liufh on 2015/7/16.
 */
public class FullBean {

	public FullBean() {
	}

	/**
	 * 
	 * @param request
	 * @param formName
	 *            实体类全名
	 * @return
	 */
	public static ActionForm full(HttpServletRequest request, String formName) {
		ActionForm object = null;
		try {
			Class clazz = Class.forName(formName);
			object = (ActionForm) clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				f.set(object, request.getParameter(f.getName()));
				f.setAccessible(false);
			}
		} catch (Exception e) {
			System.out.println("严重:form装载失败!.......");
			e.printStackTrace();
		}
		return object;
	}
}
