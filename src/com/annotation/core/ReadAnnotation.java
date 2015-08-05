/**
 * 
 */
package com.annotation.core;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Description:解析包的注解
 * 
 * @author liufeihua
 * @date 2015年8月3日下午9:45:00
 * @version 1.0
 * 
 */
public class ReadAnnotation {

	/**
	 * 解析action包
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<AnnotationBean> parseAnnotation(String pagePath) {

		List<String> classNameList = getClassName(pagePath, null);

		List<AnnotationBean> annotationBeans = new ArrayList<>();

		AnnotationBean bean = null;

		for (String className : classNameList) {
			bean = new AnnotationBean();
			bean.setActionClass(className);// 获取类的全类名

			System.out.println("类名:" + className);
			try {
				Class<?> clazz = Class.forName(className);

				if (clazz.isAnnotationPresent(Form.class)) {
					Form form = clazz.getAnnotation(Form.class);
					bean.setFormClass(form.form());// 获取实体的全类名
					System.out.println("实体名:" + form.form());
				}

				Method[] methods = clazz.getDeclaredMethods();
				List<String> pList = new ArrayList<>();
				for (Method method : methods) {
					if (method.isAnnotationPresent(Path.class)) {
						Path path = method.getAnnotation(Path.class);
						pList.add(path.value());
						System.out.println("方法上的路径:" + path.value());
					}

				}

				bean.setPath(pList);
			} catch (ClassNotFoundException e) {
				System.out.println("严重：加载类错误，没找到这个类!");
				e.printStackTrace();
			}
			annotationBeans.add(bean);
		}
		return annotationBeans;
	}

	/**
	 * 取得某一类所在包的所有类名 不含迭代
	 */
	public static List<String> getClassName(String pageName) {
		String filePath = ClassLoader.getSystemResource("").getPath()
				+ pageName.replace(".", "\\");
		List<String> fileNames = getClassName(filePath, null);

		return null;
	}

	/**
	 * @param filePath
	 * @param className
	 * @return
	 */
	private static List<String> getClassName(String filePath,
			List<String> className) {
		List<String> myClassName = new ArrayList<String>();
		File file = new File(filePath);
		File[] childFiles = file.listFiles();
		for (File childFile : childFiles) {
			if (childFile.isDirectory()) {
				myClassName.addAll(getClassName(childFile.getPath(),
						myClassName));
			} else {
				String childFilePath = childFile.getPath();
				childFilePath = childFilePath.substring(
						childFilePath.indexOf("\\classes") + 9,
						childFilePath.lastIndexOf("."));
				childFilePath = childFilePath.replace("\\", ".");
				myClassName.add(childFilePath);
			}
		}

		return myClassName;
	}

	@Test
	public void testClassName() throws Exception {

		// List<String> classNames = getClassName("com.annotation.demo.action");

		// Map<String, AnnotationBean> map =
		// parseAnnotation("com.annotation.demo.action");
		// // for (String classname : classNames) {
		// //
		// // System.out.println("类名:" + classname);
		// // }
		// Set keySet = map.keySet();
		// for (Iterator it = keySet.iterator(); it.hasNext();) {
		//
		// String key = (String) it.next();
		// System.out.println("=====");
		// System.out.println(key);
		// System.out.println("=====");
		// System.out.println(map.get(key));
		// }
		parseAnnotation("com.annotation.demo.action");
	}
}
