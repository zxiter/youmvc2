/**
 * 
 */
package com.annotation.demo.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.annotation.core.Form;
import com.annotation.core.Path;
import com.annotation.demo.model.DemoForm;
import com.youmvc.model.Action;
import com.youmvc.model.ActionForm;

/**
 * Description:TODO
 * 
 * @author liufeihua
 * @date 2015年8月3日下午9:53:52
 * @version 1.0
 * 
 */
@Form(form = "com.annotation.demo.model.DemoForm")
public class DemoAnnotation implements Action {

	@Path("/demoMethod")
	public String demoMethod(HttpServletRequest request, ActionForm form) {
		DemoForm demoForm = (DemoForm) form;
		System.out.println(demoForm);
		request.setAttribute("message", "success");
		return "success.jsp";
	}

	@Path("/demoMethod2")
	public String demoMethod2(HttpServletRequest request, ActionForm form) {
		System.out.println("demoMethod2");
		DemoForm demoForm = (DemoForm) form;
		request.setAttribute("message", "fail");
		return "fail.jsp";
	}

	@Override
	public String execute(HttpServletRequest request, ActionForm form,
			Map<String, String> actionForward) {
		// TODO Auto-generated method stub
		return null;
	}
}
