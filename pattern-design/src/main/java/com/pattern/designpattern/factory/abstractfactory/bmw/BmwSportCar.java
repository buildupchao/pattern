package com.pattern.designpattern.factory.abstractfactory.bmw;

public class BmwSportCar extends BmwCar {

	@Override
	public void drive() {
		System.out.println(this.getName() + " BmwSportCar.");
	}
}
