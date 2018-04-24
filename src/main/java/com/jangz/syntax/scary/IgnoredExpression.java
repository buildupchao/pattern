package com.jangz.syntax.scary;

public class IgnoredExpression {

	public static void likeFullRangeCheck() {
		double a = Double.POSITIVE_INFINITY * 0;
		double b = Double.POSITIVE_INFINITY * 0;
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("The checking result is " + (a > b || a <= b)); // false
		
		double c = Double.NaN;
		double d = Double.NaN;
		System.out.println("The checking result is " + (c > d || c <= d)); // false
	}
	
	public static void pierceStatic() {
		IgnoredExpression obj = null;
		System.out.println(obj.foo());
	}
	
	private static String foo() {
		System.out.println("foo called");
		return "Return from foo called.";
	}
	
	public static void main(String[] args) {
//		likeFullRangeCheck();
		pierceStatic();
	}
}
