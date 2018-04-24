package com.jangz.pattern.stategy.behavior;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Quack...");
	}

}
