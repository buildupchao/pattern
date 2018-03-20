package com.jangz.algothinking.crack;

public class LetStackOverflowAgain {
	
	public static void main(String[] args) {
		new LetStackOverflowAgain().test();
	}
	
	public void test() {
		test();
	}
}
