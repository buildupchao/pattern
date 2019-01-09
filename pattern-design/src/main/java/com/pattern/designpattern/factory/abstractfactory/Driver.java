package com.pattern.designpattern.factory.abstractfactory;

import com.pattern.designpattern.factory.abstractfactory.benz.BenzCar;
import com.pattern.designpattern.factory.abstractfactory.bmw.BmwCar;

public abstract class Driver {
	
	public abstract BenzCar createBenzCar(String car) throws Exception;
	
	public abstract BmwCar createBmwCar(String car) throws Exception;
}
