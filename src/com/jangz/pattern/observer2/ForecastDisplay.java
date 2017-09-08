package com.jangz.pattern.observer2;

import java.util.Observable;
import java.util.Observer;

import com.jangz.pattern.observer.DisplayElement;

public class ForecastDisplay implements Observer, DisplayElement {

	Observable observable;
	private float currentPressure = 29.92f;
	private float lastPressure;

	public ForecastDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Forecast: Improving weather on the way!");
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			lastPressure = currentPressure;
			currentPressure = weatherData.getPressure();
			display();
		}
	}

}
