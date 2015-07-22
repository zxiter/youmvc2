package com.youmvc.action;

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
 * Created by liufh on 2015/7/16.
 */
@WebServlet(name = "actionServlet", urlPatterns = "*.do")
public class ActionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// //String sign=req.getParameter("sign");
		//
		// //转换传输字符的编码
		// req.setCharacterEncoding("utf-8");
		// resp.setCharacterEncoding("utf-8");
		// // LoginForm loginForm=(LoginForm)FullBean.full( req);
		// ActionForm actionForm=FullBean.full( req);
		// Action action=null;
		// // if
		// (req.getParameter("sign").equals("com.youmvc.model.LoginForm")){
		// // action=new LoginAction();
		// // }else if
		// (req.getParameter("sign").equals("com.youmvc.model.ZhuCeForm")){
		// // action=new ZhuCeAction();
		// // }
		//
		// Map<String,String> map= ActionMapping.getMap();
		//
		// try {
		// String actionName=map.get(req.getParameter("sign"));
		// Class clazz=Class.forName(actionName);
		// action= (Action) clazz.newInstance();
		// }catch (Exception e){
		// e.printStackTrace();
		// }
		//
		// // String message=action.execute(req,actionForm);
		// //
		// // req.setAttribute("message", message);
		// //
		// // String url="/public.jsp";
		//
		// String url=action.execute(req,actionForm,);
		//
		// req.getRequestDispatcher(url).forward(req,resp);

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
