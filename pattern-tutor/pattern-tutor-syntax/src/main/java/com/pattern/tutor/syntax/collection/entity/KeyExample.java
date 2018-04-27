package com.pattern.tutor.syntax.collection.entity;

import java.io.Serializable;
import java.util.Objects;

public class KeyExample implements Serializable {

	private static final long serialVersionUID = -952540654823826528L;
	private String name;
	private Integer number;

	public KeyExample() {
		super();
	}

	public KeyExample(String name, Integer number) {
		super();
		this.name = name;
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof KeyExample)) {
			return false;
		}
		KeyExample current = (KeyExample) obj;
		return Objects.equals(this.name, current.name) && Objects.equals(this.number, current.number);
	}

	@Override
	public int hashCode() {
		return this.number % 5;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
