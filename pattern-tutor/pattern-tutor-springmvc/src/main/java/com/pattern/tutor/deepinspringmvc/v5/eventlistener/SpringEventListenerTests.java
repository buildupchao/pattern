package com.pattern.tutor.deepinspringmvc.v5.eventlistener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class SpringEventListenerTests {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringEventListenerTests.class);
		MailSender sender = ctx.getBean(MailSender.class);
		sender.sendEmail("zhangyachao@wps.cn");
	}
}
