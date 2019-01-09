package com.pattern.designpattern.factory.abstractfactory.benz;

public class BenzSportCar extends BenzCar {

	@Override
	public void drive() {
		System.out.println(this.getName() + " BenzSportCar.");
	}
}
