package com.pattern.tutor.deepinspringmvc.v5.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomBeanLifeCycle {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomBeanLifeCycle.class);

	public CustomBeanLifeCycle() {
		LOGGER.info("CustomBeanLifeCycle init___________");
	}
	
	public void test() {
		LOGGER.info(">CustomBeanLifeCycle<");
	}

	public void start() {
		LOGGER.info("CustomBeanLifeCycle start!");
	}
	
	public void destory() {
		LOGGER.info("CustomBeanLifeCycle destory!");
	}
}
