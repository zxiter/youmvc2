/**
 * 
 */
package com.annotation.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.youmvc.model.XmlBean;

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
	public static Map<String, XmlBean> parseAnnotation(String xmlPath) {

		return null;
	}

	/**
	 * 取得某一类所在包的所有类名 不含迭代
	 */
	public static List<String> getClassName(String pageName) {
		String filePath = ClassLoader.getSystemResource("").getPath()
				+ pageName.replace(".", "\\");
		List<String> fileNames = getClassName(filePath, null);

		return fileNames;
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

	// @Test
	// public void testClassName() throws Exception {
	//
	// List<String> classNames = getClassName("com.annotation.demo.action");
	//
	// for (String classname : classNames) {
	//
	// System.out.println("类名:" + classname);
	// }
	// }
}
