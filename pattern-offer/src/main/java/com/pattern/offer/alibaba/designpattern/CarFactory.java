package com.pattern.offer.alibaba.designpattern;

import com.pattern.offer.alibaba.designpattern.brand.Brand;
import com.pattern.offer.alibaba.designpattern.type.Type;

public class CarFactory {
	
	public Car createCar(Type type, Brand brand) {
		return new Car(type, brand);
	}
}
