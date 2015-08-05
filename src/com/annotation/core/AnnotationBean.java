package com.annotation.core;

import java.util.List;

/**
 * Description:用来存解析出来注解
 * 
 * @author liufeihua
 * @date 2015年8月3日下午9:45:00
 * @version 1.0
 * 
 */
public class AnnotationBean {

	private String formClass = "";// bean的类

	private List<String> path;;// 访问的路径

	private String actionClass = "";// 访问的action

	public List<String> getPath() {
		return path;
	}

	public void setPath(List<String> path) {
		this.path = path;
	}

	public String getActionClass() {
		return actionClass;
	}

	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}

	public String getFormClass() {
		return formClass;
	}

	public void setFormClass(String formClass) {
		this.formClass = formClass;
	}

	@Override
	public String toString() {
		return "AnnotationBean [formClass=" + formClass + ", path=" + path
				+ ", actionClass=" + actionClass + "]";
	}

}
