package com.pattern.tutor.deepinjvm.bytecode;

public class FirstExample {

	private int m = 1;
	private int n = 2;
	private static int k = 3;
	
	public static void methodOne(int i) {
		int j = 0;
		int sum = i + j;
		
		int result = methodTwo(sum);
		System.out.println(result);
	}
	
	public static int methodTwo(int x) {
		return x * 2;
	}
	
	public static void main(String[] args) {
		methodOne(8);
	}
}
