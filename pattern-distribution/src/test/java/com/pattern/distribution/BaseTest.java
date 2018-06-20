package com.pattern.distribution;

import java.util.Objects;

import org.junit.Before;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pattern.distribution.balance.ClusterEngine;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseTest {

	protected AnnotationConfigApplicationContext ctx;
	
	@Before
	public void initialize() {
		this.ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Objects.requireNonNull(ctx, "ApplicationContext cannot be null.");
		log.info(">>>>>>Initializing application context success.");
		
//		loadClusterEngine();
	}
	
	private void loadClusterEngine() {
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ctx.getAutowireCapableBeanFactory();
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(ClusterEngine.class);
		beanFactory.registerBeanDefinition("clusterEngine", beanDefinitionBuilder.getBeanDefinition());
		
		log.info(">>>>>>Load ClusterEngine success.");
	}
	
	public ClusterEngine clusterEngine() {
		return ctx.getBean(ClusterEngine.class);
	}
}
