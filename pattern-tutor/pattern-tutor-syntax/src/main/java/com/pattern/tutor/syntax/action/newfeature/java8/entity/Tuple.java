package com.pattern.tutor.syntax.action.newfeature.java8.entity;

public class Tuple {
	private Number a;
	private Number b;
	private Number c;

	public Tuple(Number a, Number b, Number c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Number getA() {
		return a;
	}

	public void setA(Number a) {
		this.a = a;
	}

	public Number getB() {
		return b;
	}

	public void setB(Number b) {
		this.b = b;
	}

	public Number getC() {
		return c;
	}

	public void setC(Number c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "(" + a + ", " + b + ", " + c + ")";
	}

}
