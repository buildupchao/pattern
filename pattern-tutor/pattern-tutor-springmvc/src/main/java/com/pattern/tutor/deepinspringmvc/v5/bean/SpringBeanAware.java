package com.pattern.tutor.deepinspringmvc.v5.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanAware implements ApplicationContextAware {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBeanAware.class);
	
	private ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
		LOGGER.info("______context=[{}]\n", context.toString());
	}
}
