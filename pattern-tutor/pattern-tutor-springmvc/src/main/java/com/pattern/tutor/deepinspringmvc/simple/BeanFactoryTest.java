package com.pattern.tutor.deepinspringmvc.simple;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import junit.framework.Assert;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("deprecation")
public class BeanFactoryTest {

	@Test
	public void testSimpleLoad() {
		String basePath = "com/pattern/tutor/deepinspringmvc/simple";
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(basePath + "/beanFactoryTest.xml"));
		MyTestBean bean = (MyTestBean) beanFactory.getBean("myTestBean");
		Assert.assertEquals("testStr", bean.getTestStr());
		log.info("No message is the best news.");
	}
}
