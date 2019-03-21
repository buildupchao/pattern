package com.pattern.tutor.deepinspringmvc.v5.factorybean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.pattern.tutor.deepinspringmvc.v5.factorybean.bean.Car;
import com.pattern.tutor.deepinspringmvc.v5.factorybean.factorybean.CarFactoryBean;

@Configuration
public class BeanConfig {

	@Bean
	public CarFactoryBean carFactoryBean() {
		String carInfo = "BMW,5000,9990000";
		return new CarFactoryBean(carInfo);
	}
	
	@Bean
	@Primary
	public Car car(CarFactoryBean carFactoryBean) throws Exception {
		return carFactoryBean.getObject();
	}
}
