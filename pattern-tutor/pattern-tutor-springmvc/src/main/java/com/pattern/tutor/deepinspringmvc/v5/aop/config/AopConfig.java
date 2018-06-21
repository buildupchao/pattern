package com.pattern.tutor.deepinspringmvc.v5.aop.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Component
@Aspect
@Slf4j
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan(basePackages = "com.pattern.tutor.deepinspringmvc.v5.aop.*")
public class AopConfig {
	
	/**
	 * @Pointcut("execution(* com.pattern.tutor.deepinspringmvc.v5.aop.service.*.save(..))") ..代表所有参数
	 * @Pointcut("execution(* com.pattern.tutor.deepinspringmvc.v5.aop.service.*.*())") 指定所有方法
	 * @Pointcut("execution(* com.pattern.tutor.deepinspringmvc.v5.aop.service.*.save())") 指定save方法
	 * @see
	 */
	
	@Pointcut(value = "execution(* com.pattern.tutor.deepinspringmvc.v5.aop.service.*.*(..))")
	public void pointCut() {}
	
	@Before(value = "pointCut()")
	public void before() {
		log.info(">>>>>>Open transaction.");
	}
	
	@After(value = "pointCut()")
	public void after() {
		log.info(">>>>>>Close transaction.");
	}
}
