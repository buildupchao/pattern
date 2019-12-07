package com.pattern.tutor.deepinspringmvc.v5.retry.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author buildupchao
 * @date 2019/08/26 09:37
 * @since JDK 1.8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Retryable {
	/**
	 * 重试次数
	 * @return
	 */
	int retryTimes() default 3;
	/**
	 * 重试时间间隔，时间单位为毫秒
	 * @return
	 */
	int retryInterval() default 1000;
}
