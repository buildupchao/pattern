package com.pattern.codingthinking.algothinking.crack;

public class LetStackOverflow {

	public static void main(String[] args) {
		int number = 10000000;
		int result = new LetStackOverflow().iterate(number);
		System.out.println(number + "! = " + result);
	}
	
	public int iterate(int number) {
		if (number == 1)
			return 1;
		return number * iterate(number - 1);
	}
}
