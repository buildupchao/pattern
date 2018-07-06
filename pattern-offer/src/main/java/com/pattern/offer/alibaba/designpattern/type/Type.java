package com.pattern.offer.alibaba.designpattern.type;

public abstract class Type {
	
	protected CarColor color;
	
	enum CarColor {
		WHITE, RED, BLUE
	}

	public CarColor getColor() {
		return color;
	}

	public void setColor(CarColor color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "{\"color\":\"" + color.name() + "\"}";
	}
}
