package com.pattern.tutor.deepinspringmvc.v5.retry;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.pattern.tutor.deepinspringmvc.v5.retry.service.HelloService;

/**
 * @author buildupchao
 * @date 2019/08/26 09:36
 * @since JDK 1.8
 */
@ComponentScan
public class RetryApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RetryApplication.class);
		HelloService helloService = ctx.getBean(HelloService.class);
		String helloMessage = helloService.hello("buildupchao");
		System.out.println(helloMessage);
//		ctx.close();
	}
}
