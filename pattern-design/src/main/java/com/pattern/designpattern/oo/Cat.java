package com.pattern.designpattern.oo;

public class Cat extends Animal {
	
	private void meow() {
		System.out.println("meow...");
	}

	@Override
	public void makeSound() {
		meow();
	}
}
