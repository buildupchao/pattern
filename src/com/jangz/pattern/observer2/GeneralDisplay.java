package com.jangz.pattern.observer2;

import java.util.Observable;
import java.util.Observer;

import com.jangz.pattern.observer.DisplayElement;

public class GeneralDisplay implements Observer, DisplayElement {

	@Override
	public void update(Observable o, Object arg) {
		
	}

	@Override
	public void display() {
//		System.out.println("temperature={" + temperature + "}, humidity={" + humidity + "}");
	}

}
