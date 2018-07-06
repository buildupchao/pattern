package com.pattern.offer.alibaba.designpattern;

import com.pattern.offer.alibaba.designpattern.brand.Brand;
import com.pattern.offer.alibaba.designpattern.type.Type;

public class Car {
	Type type;
	Brand brand;

	public Car(Type type, Brand brand) {
		super();
		this.type = type;
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "{\"type\":\"" + type + "\", \"brand\":\"" + brand + "\"}";
	}

}
