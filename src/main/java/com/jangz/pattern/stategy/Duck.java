package com.jangz.pattern.stategy;

import com.jangz.pattern.stategy.behavior.FlyBehavior;
import com.jangz.pattern.stategy.behavior.QuackBehavior;

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
