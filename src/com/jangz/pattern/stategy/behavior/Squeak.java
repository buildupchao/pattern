package com.jangz.pattern.stategy.behavior;

public class Squeak implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Squeak...");
	}

}
