package com.jangz.syntax.action.newfeature.java8.entity;

public class Pair<T> {
	private T x;
	private T y;

	public Pair(T x, T y) {
		this.x = x;
		this.y = y;
	}

	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}

	public T getY() {
		return y;
	}

	public void setY(T y) {
		this.y = y;
	}

	public Integer sum() {
		return x.hashCode() + y.hashCode();
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
