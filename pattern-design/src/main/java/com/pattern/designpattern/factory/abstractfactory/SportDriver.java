package com.pattern.designpattern.factory.abstractfactory;

import com.pattern.designpattern.factory.abstractfactory.benz.BenzCar;
import com.pattern.designpattern.factory.abstractfactory.benz.BenzSportCar;
import com.pattern.designpattern.factory.abstractfactory.bmw.BmwCar;
import com.pattern.designpattern.factory.abstractfactory.bmw.BmwSportCar;

public class SportDriver extends Driver {

	@Override
	public BenzCar createBenzCar(String car) throws Exception {
		return new BenzSportCar();
	}

	@Override
	public BmwCar createBmwCar(String car) throws Exception {
		return new BmwSportCar();
	}

}
