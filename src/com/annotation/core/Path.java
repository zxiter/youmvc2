package com.annotation.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:TODO
 * 
 * @author liufeihua
 * @date 2015年8月5日上午9:28:43
 * @version 1.0
 * 
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
// 可以用于类和方法
@Retention(RetentionPolicy.RUNTIME)
public @interface Path {

	String value();
}
