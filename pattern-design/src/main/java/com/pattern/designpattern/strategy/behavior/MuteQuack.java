package com.pattern.designpattern.strategy.behavior;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Mute quack...");
	}

}
