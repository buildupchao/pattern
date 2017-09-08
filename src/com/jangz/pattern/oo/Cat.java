package com.jangz.pattern.oo;

public class Cat extends Animal {
	
	private void meow() {
		System.out.println("meow...");
	}

	@Override
	public void makeSound() {
		meow();
	}
}
