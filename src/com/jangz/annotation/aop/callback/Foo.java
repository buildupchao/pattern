package com.jangz.annotation.aop.callback;

public class Foo {

	void algo1() {
		algo(1_000_000_000);
	}

	void algo2() {
		algo(2_000_000_000);
	}

	void algo3() {
		algo(100_000_000);
	}
	
	protected long algo(long n) {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += i;
		}
		return sum;
	}
}
