package com.pattern.designpattern.oo;

public abstract class Animal {

	Fly fly;

	public void setFly(Fly fly) {
		this.fly = fly;
	}

	public abstract void makeSound();

	public void makeFly() {
		fly.fly();
	}
}
