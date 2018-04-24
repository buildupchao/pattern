package com.pattern.designpattern.strategy;

import com.pattern.designpattern.strategy.behavior.FlyWithWings;
import com.pattern.designpattern.strategy.behavior.Quack;

public class Test {
	
	public static void main(String[] args) {
		Duck duck = new MallardDuck();
		duck.setFlyBehavior(new FlyWithWings());
		duck.setQuackBehavior(new Quack());
		
		duck.performFly();
		duck.performQuack();
	}
	
}
