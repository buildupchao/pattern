package com.pattern.designpattern.factory.abstractfactory;

import com.pattern.designpattern.factory.abstractfactory.benz.BenzBusinessCar;
import com.pattern.designpattern.factory.abstractfactory.benz.BenzCar;
import com.pattern.designpattern.factory.abstractfactory.bmw.BmwBussinessCar;
import com.pattern.designpattern.factory.abstractfactory.bmw.BmwCar;

public class BussinessDriver extends Driver {

	@Override
	public BenzCar createBenzCar(String car) throws Exception {
		return new BenzBusinessCar();
	}

	@Override
	public BmwCar createBmwCar(String car) throws Exception {
		return new BmwBussinessCar();
	}

}
