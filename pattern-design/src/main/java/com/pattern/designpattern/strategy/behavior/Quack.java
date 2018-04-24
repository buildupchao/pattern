package com.pattern.designpattern.strategy.behavior;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Quack...");
	}

}
