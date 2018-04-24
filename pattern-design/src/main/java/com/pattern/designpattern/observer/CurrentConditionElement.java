package com.pattern.designpattern.observer;

import org.apache.log4j.Logger;

public class CurrentConditionElement implements Observer, DisplayElement {
	private static final Logger logger = Logger.getLogger(CurrentConditionElement.class);

	private float temperature;
	private float humidity;
	private Subject weatherData;

	public CurrentConditionElement(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		// logger.info("temperature={" + temperature + "}, humidity={" +
		// humidity + "}");
		System.out.println("temperature={" + temperature + "}, humidity={" + humidity + "}");
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

}
