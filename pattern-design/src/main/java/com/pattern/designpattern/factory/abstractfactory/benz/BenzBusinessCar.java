package com.pattern.designpattern.factory.abstractfactory.benz;

public class BenzBusinessCar extends BenzCar {

	@Override
	public void drive() {
		System.out.println(this.getName() + " BenzBusinessCar.");		
	}

}
