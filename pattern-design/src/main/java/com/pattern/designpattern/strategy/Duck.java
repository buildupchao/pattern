package com.pattern.designpattern.strategy;

import com.pattern.designpattern.strategy.behavior.FlyBehavior;
import com.pattern.designpattern.strategy.behavior.QuackBehavior;

public class Duck {

	private FlyBehavior flyBehavior;
	private QuackBehavior quackBehavior;

	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
}
