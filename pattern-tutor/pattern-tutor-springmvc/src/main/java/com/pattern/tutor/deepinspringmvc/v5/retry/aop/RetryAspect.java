package com.pattern.tutor.deepinspringmvc.v5.retry.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pattern.tutor.deepinspringmvc.v5.retry.annotation.Retryable;

/**
 * @author buildupchao
 * @date 2019/08/26 09:40
 * @since JDK 1.8
 */
@Aspect
@Component
public class RetryAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(RetryAspect.class);
	
	@Pointcut("@annotation(com.pattern.tutor.deepinspringmvc.v5.retry.annotation.Retryable)")
	private void retryInvokeMethod() {}
	
	@Around("retryInvokeMethod()")
	public Object retry(ProceedingJoinPoint joinPoint) throws InterruptedException {
		Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
		Retryable retryable = method.getAnnotation(Retryable.class);
		int retryTimes = retryable.retryTimes();
		int retryInterval = retryable.retryInterval();
		
		Throwable error = new RuntimeException();
		for (int retry = 1; retry <= retryTimes; retry++) {
			try {
				Object result = joinPoint.proceed();
				return result;
			} catch (Throwable throwable) {
				error = throwable;
				LOGGER.warn("call method {} error, will retry {} time(s).", method.getName(), retry);
			}
			Thread.sleep(retryInterval);
		}
		throw new RuntimeException("has no more retry times.", error);
	}
}
