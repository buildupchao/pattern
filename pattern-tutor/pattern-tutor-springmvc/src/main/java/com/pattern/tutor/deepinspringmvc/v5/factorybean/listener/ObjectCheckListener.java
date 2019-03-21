package com.pattern.tutor.deepinspringmvc.v5.factorybean.listener;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pattern.tutor.deepinspringmvc.v5.factorybean.bean.Car;

@Component
public class ObjectCheckListener implements InitializingBean {

	@Autowired
	private Car car;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("initialize[get car info: " + car.toString() + "]");		
	}
}
