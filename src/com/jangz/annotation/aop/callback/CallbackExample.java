package com.jangz.annotation.aop.callback;

public class CallbackExample {
	
	public static void main(String[] args) {
		TimerUtil timer = new TimerUtil();
		timer.getTime(() -> new Foo().algo1());
		timer.getTime(() -> new Foo().algo2());
		timer.getTime(() -> new Foo().algo3());
	}
}
