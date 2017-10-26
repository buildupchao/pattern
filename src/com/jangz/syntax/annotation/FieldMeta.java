package com.jangz.syntax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
public @interface FieldMeta {
	
	/**
	 * 是否为序列号
	 * @return
	 */
	boolean id() default false;
	
	/**
	 * 字段名称
	 * @return
	 */
	String name() default "";
	
	/**
	 * 是否可编辑
	 * @return
	 */
	boolean editable() default true;
	
	/**
	 * 是否在列表中显示
	 * @return
	 */
	boolean summary() default true;
	
	/**
	 * 字段描述
	 * @return
	 */
	String description() default "";
	
	/**
	 * 排序字段
	 * @return
	 */
	int order() default 0;
}
