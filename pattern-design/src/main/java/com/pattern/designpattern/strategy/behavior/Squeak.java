package com.pattern.designpattern.strategy.behavior;

public class Squeak implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Squeak...");
	}

}
