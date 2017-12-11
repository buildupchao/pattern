package com.jangz.newfeature.entity;

public class Color {
	private Integer red;
	private Integer yellow;
	private Integer blue;

	public Color() {
	}

	public Color(Integer red, Integer yellow, Integer blue) {
		this.red = red;
		this.yellow = yellow;
		this.blue = blue;
	}

	public Integer getRed() {
		return red;
	}

	public void setRed(Integer red) {
		this.red = red;
	}

	public Integer getYellow() {
		return yellow;
	}

	public void setYellow(Integer yellow) {
		this.yellow = yellow;
	}

	public Integer getBlue() {
		return blue;
	}

	public void setBlue(Integer blue) {
		this.blue = blue;
	}

	@Override
	public String toString() {
		return "Color [red=" + red + ", yellow=" + yellow + ", blue=" + blue + "]";
	}

}
