package com.jangz.pattern.stategy;

import com.jangz.pattern.stategy.behavior.FlyWithWings;
import com.jangz.pattern.stategy.behavior.Quack;

public class Test {
	
	public static void main(String[] args) {
		Duck duck = new MallardDuck();
		duck.setFlyBehavior(new FlyWithWings());
		duck.setQuackBehavior(new Quack());
		
		duck.performFly();
		duck.performQuack();
	}
	
}
