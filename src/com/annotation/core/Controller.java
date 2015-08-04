/**
 * 
 */
package com.annotation.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:TODO
 * 
 * @author liufeihua
 * @date 2015年8月3日下午9:28:20
 * @version 1.0
 * 
 */
@Target(ElementType.TYPE)
// 只能用于类
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {

	String value() default "index";
}
