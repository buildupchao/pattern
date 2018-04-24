package com.pattern.designpattern.strategy.behavior;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("Fly without wings...");
	}

}
