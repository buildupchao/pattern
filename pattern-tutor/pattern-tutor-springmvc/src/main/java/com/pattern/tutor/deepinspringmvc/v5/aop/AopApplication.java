package com.pattern.tutor.deepinspringmvc.v5.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pattern.tutor.deepinspringmvc.v5.aop.config.AopConfig;
import com.pattern.tutor.deepinspringmvc.v5.aop.service.UserService;

public class AopApplication {

	private static AnnotationConfigApplicationContext ctx;
	
	public static void main(String[] args) {
		ctx = new AnnotationConfigApplicationContext(AopConfig.class);
		
		testSave();
		
		ctx.close();
	}
	
	public static void testSave() {
		UserService userService = ctx.getBean(UserService.class);
		System.out.println(userService.getClass());
		userService.save();
	}
}
