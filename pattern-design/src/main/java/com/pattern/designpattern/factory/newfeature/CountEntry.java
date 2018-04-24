package com.pattern.designpattern.factory.newfeature;

import java.io.Serializable;

public class CountEntry implements Serializable {

	private static final long serialVersionUID = 2020877421452669942L;

	private int code;

	private int count;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
