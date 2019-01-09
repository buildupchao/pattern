package com.pattern.designpattern.factory.abstractfactory.bmw;

public abstract class BmwCar {

	private String name;

	public abstract void drive();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
