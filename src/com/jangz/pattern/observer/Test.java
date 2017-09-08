package com.jangz.pattern.observer;

public class Test {
	
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionElement currentDisplay = new CurrentConditionElement(weatherData);
		
		weatherData.setMeasurements(80, 65, 34.5f);
		weatherData.setMeasurements(82, 70, 27.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
	
}
