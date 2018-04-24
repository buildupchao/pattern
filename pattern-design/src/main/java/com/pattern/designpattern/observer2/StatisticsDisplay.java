package com.pattern.designpattern.observer2;

import java.util.Observable;
import java.util.Observer;

import com.pattern.designpattern.observer.DisplayElement;

public class StatisticsDisplay implements Observer, DisplayElement {

	Observable observable;
	private float temperature;
	private float humidity;

	public StatisticsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}

}
