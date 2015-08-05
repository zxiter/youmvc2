package com.annotation.core;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youmvc.model.ActionForm;
import com.youmvc.util.FullBean;

/**
 * Description:总的控制器
 * 
 * @author liufeihua
 * @date 2015年8月5日上午9:28:43
 * @version 1.0
 * 
 */
@WebServlet(name = "annotationAction", urlPatterns = "*.a")
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

		String path = this.getPath(req);// 获取访问的路径，路径要和访问的方法要一样，否则无法访问得到

		List<AnnotationBean> list = (List<AnnotationBean>) this
				.getServletContext().getAttribute("struts_annotation");// 从context环境中获取启动时得到的注解集合
		for (AnnotationBean a : list) {
			List<String> annotationBeanPath = a.getPath();
			if (annotationBeanPath.contains(path)) {// 判断是否有访问的路径（方法）

				ActionForm actionForm = FullBean.full(req, a.getFormClass());// 得到实体，谁用谁转换

				String actionType = a.getActionClass();// 访问控制器的类的全名称

				Class clazz = null;
				try {
					clazz = Class.forName(actionType);
					Method method = clazz.getDeclaredMethod(path.substring(1),
							new Class[] { HttpServletRequest.class,
									ActionForm.class });
					String url = (String) method.invoke(clazz.newInstance(),
							new Object[] { req, actionForm });

					req.getRequestDispatcher(url).forward(req, resp);
				} catch (Exception e) {
					System.out.println("信息:加载注解控制器失败!");
					e.printStackTrace();
				}
				break;
			} else {
				System.out.println("信息:没有这个方法!");
			}
		}

	}

	public String getPath(HttpServletRequest request) {
		return request.getServletPath().split("\\.")[0];
	}
}
