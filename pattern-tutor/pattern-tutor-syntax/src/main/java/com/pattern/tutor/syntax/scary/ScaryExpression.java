package com.pattern.tutor.syntax.scary;

public class ScaryExpression {
	
	public static void autoIncrement() {
		int count = 0;
		for (int i = 0; i < 100; i++)
			count = count++;
		System.out.printf("count is %d.\n", count);
	}
	
	public static void main(String[] args) {
		autoIncrement();
	}
}
