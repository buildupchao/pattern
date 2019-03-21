package com.pattern.tutor.deepinspringmvc.v5.factorybean.factorybean;

import org.springframework.beans.factory.FactoryBean;

import com.pattern.tutor.deepinspringmvc.v5.factorybean.bean.Car;

public class CarFactoryBean implements FactoryBean<Car> {

	private String carInfo;
	
	public CarFactoryBean(String carInfo) {
		super();
		this.carInfo = carInfo;
	}

	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		String[] carInfos = carInfo.split(",");
		car.setBrand(carInfos[0]);
		car.setMaxSpeed(Integer.parseInt(carInfos[1]));
		car.setPrice(Double.parseDouble(carInfos[2]));
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}
}
