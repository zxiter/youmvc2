package com.annotation.core;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youmvc.model.Action;
import com.youmvc.model.ActionForm;
import com.youmvc.model.XmlBean;
import com.youmvc.util.FullBean;

/**
 * Description:TODO
 * 
 * @author liufeihua
 * @date 2015年8月3日下午9:28:43
 * @version 1.0
 * 
 */
@WebServlet(name = "annotationAction", urlPatterns = "annotationAction.do")
public class AnnotationAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println(getPath(req));

		String path = this.getPath(req);

		Map<String, XmlBean> map = (Map<String, XmlBean>) this
				.getServletContext().getAttribute("struts");
		XmlBean xmlBean = map.get(path);

		if (null == xmlBean) {
			System.out.println("信息:没有这个方法!");
		} else {
			ActionForm actionForm = FullBean.full(req, xmlBean.getFormClass());

			String actionType = xmlBean.getActionType();
			Map<String, String> actionForward = xmlBean.getActionForward();

			Action action = null;

			try {
				Class clazz = Class.forName(actionType);
				action = (Action) clazz.newInstance();
			} catch (Exception e) {
				System.out.println("信息:加载控制器失败!");
				e.printStackTrace();
			}

			String url = action.execute(req, actionForm, actionForward);
			req.getRequestDispatcher(url).forward(req, resp);
		}

	}

	public String getPath(HttpServletRequest request) {
		return request.getServletPath().split("\\.")[0];
	}
}
