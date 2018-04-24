package com.pattern.designpattern.oo;

public class Test {
	
	public static void main(String[] args) {
		Fly flyNoWings = new FlyNoWings();
		Fly flyWithWinds = new FlyWithWings();
		
		Animal dog = new Dog();
		dog.setFly(flyNoWings);
		dog.makeFly();
		
		Animal cat = new Cat();
		cat.setFly(flyWithWinds);
		cat.makeFly();
	}
	
}
