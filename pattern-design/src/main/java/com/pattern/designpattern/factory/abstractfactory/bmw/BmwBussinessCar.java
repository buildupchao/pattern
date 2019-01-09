package com.pattern.designpattern.factory.abstractfactory.bmw;

public class BmwBussinessCar extends BmwCar {

	@Override
	public void drive() {
		System.out.println(this.getName() + " BmwBussinessCar.");		
	}

}
