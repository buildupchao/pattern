package com.pattern.tutor.deepinspringmvc.v5.bean;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanLifeCycle implements BeanPostProcessor, InitializingBean, DisposableBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBeanLifeCycle.class);
	
	private static final String str = "This string is only used to testing.";
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("annotationBean".equals(beanName)) {
			LOGGER.info("SpringBeanLifeCycle start beanName={}", beanName);
		}
		return bean;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (StringUtils.isEmpty(str)) {
			LOGGER.info("str/> not value!");
		} else {
			LOGGER.info("str/>" + str);
		}
		LOGGER.info("afterPropertiesSet_______________");
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("annotationBean".equals(beanName)) {
			LOGGER.info("SpringBeanLifeCycle end beanName={}", beanName);
		}
		return bean;
	}

	@Override
	public void destroy() throws Exception {
		LOGGER.info("destroy__________________________");
	}
}
