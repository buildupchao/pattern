package com.pattern.tutor.deepinspringmvc.v5.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class SpringBeanLifeCycleTests {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanLifeCycleTests.class);
		CustomBeanLifeCycle bean = context.getBean(CustomBeanLifeCycle.class);
		bean.test();
		
		DefaultListableBeanFactory beanFactory = 
				(DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
		beanFactory.removeBeanDefinition("customBeanLifeCycle");
	}
}
