package com.pattern.designpattern.factory.abstractfactory;

import com.pattern.designpattern.factory.abstractfactory.benz.BenzCar;

public class ClientRequestMain {

	public static void main(String[] args) throws Exception {
		Driver driver = new SportDriver();
		BenzCar car = driver.createBenzCar(" Superme ");
		car.drive();
	}
}
