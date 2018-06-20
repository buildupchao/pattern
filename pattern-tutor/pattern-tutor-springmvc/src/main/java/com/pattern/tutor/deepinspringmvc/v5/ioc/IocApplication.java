package com.pattern.tutor.deepinspringmvc.v5.ioc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pattern.tutor.deepinspringmvc.v5.ioc.agent.ServiceAgent;
import com.pattern.tutor.deepinspringmvc.v5.ioc.service.MockService;
import com.pattern.tutor.deepinspringmvc.v5.ioc.service.ServicePackage;

import junit.framework.Assert;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("deprecation")
@Slf4j
public class IocApplication {

	private AnnotationConfigApplicationContext ctx;

	@Before
	public void initContext() {
		this.ctx = new AnnotationConfigApplicationContext(ServicePackage.class);
		log.info(">>>>>>Load ApplicationContext success.");
		
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) this.ctx.getAutowireCapableBeanFactory();
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(ServiceAgent.class);
		beanDefinitionBuilder.addPropertyValue("mockService", this.ctx.getBean(MockService.class));
		beanFactory.registerBeanDefinition("serviceAgent", beanDefinitionBuilder.getBeanDefinition());
		log.info(">>>>>>Load ServiceAgent success.");
	}
	
	@Test
	public void testDI() {
		String message = this.ctx.getBean(ServiceAgent.class).hi("jangz");
		Assert.assertEquals("hi jangz.", message);
	}
	
	@After
	public void destroyContext() {
		this.ctx.close();
		this.ctx = null;
	}
}
