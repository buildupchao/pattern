package com.jangz.deepinspringmvc.simple;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {

	@Test
	public void testSimpleLoad() {
		String basePath = "com/jangz/deepinspringmvc/simple";
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(basePath + "/beanFactoryTest.xml"));
		MyTestBean bean = (MyTestBean) beanFactory.getBean("myTestBean");
		Assert.assertEquals("testStr", bean.getTestStr());
	}
}
