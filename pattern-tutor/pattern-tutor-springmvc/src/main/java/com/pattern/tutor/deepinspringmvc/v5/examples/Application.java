package com.pattern.tutor.deepinspringmvc.v5.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		MessagePrinter printer = ctx.getBean(MessagePrinter.class);
		printer.printMessage();
	}
}
