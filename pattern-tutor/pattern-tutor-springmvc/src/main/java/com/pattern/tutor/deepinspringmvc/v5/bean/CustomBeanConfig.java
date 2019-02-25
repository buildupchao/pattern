package com.pattern.tutor.deepinspringmvc.v5.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeanConfig {

	@Bean(initMethod = "start", destroyMethod = "destory")
	public CustomBeanLifeCycle customBeanLifeCycle() {
		return new CustomBeanLifeCycle();
	}
	
	@Bean(name = "annotationBean")
	public AnnotationBeanClass annotationBeanClass() {
		return new AnnotationBeanClass();
	}
}
