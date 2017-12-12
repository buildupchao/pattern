package com.jangz.pattern.adapter.newfeature;

import java.util.Arrays;

public class AddableArrayAdapter<T extends Number> implements Addable<T> {

	private Number[] t;

	public AddableArrayAdapter(Number[] t) {
		this.t = t;
	}

	@Override
	public Double reduce() {
//		System.out.println(t.getClass().getSimpleName());
		return Arrays.stream(t).reduce(0.0, (a, b) -> a.doubleValue() + b.doubleValue()).doubleValue();
	}

}
