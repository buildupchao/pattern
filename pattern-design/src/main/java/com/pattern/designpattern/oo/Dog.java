package com.pattern.designpattern.oo;

public class Dog extends Animal {
	
	private void bark() {
		System.out.println("bark...");
	}

	@Override
	public void makeSound() {
		bark();
	}

}
