package com.pattern.tutor.deepinspringmvc.v5.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pattern.tutor.deepinspringmvc.v5.factorybean.bean.Car;
import com.pattern.tutor.deepinspringmvc.v5.factorybean.util.SpringBeanFactory;

/**
 * @see com.pattern.tutor.deepinspringmvc.v5.factorybean.listener.ObjectCheckListener
 * @see com.pattern.tutor.deepinspringmvc.v5.factorybean.util.SpringBeanFactory
 * 
 * @author buildupchao
 *         Date: 2019/03/21 11:20
 * @since JDK 1.8
 */
public class FactoryBeanApplication {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FactoryBeanPackage.class);
		
		Car car = SpringBeanFactory.getBean(Car.class);
		System.out.println("main[get car info: " + car.toString() + "]");
		
		context.destroy();
	}
}
