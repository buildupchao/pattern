package com.pattern.tutor.syntax.scary;

public class CareForInstanceofExpression {
	
	public static void simpleExpression() {
		System.out.println("demo" instanceof Object); // true
		System.out.println(new String() instanceof String); // true
		System.out.println(new Object() instanceof String); // false
//		System.out.println('A' instanceof Character); // compiler error
		
		System.out.println(null instanceof String); // false
		System.out.println((String) null instanceof String); // false
		
		String[] str = new String[2];
		System.out.println(str instanceof String[]); // true
	}
	
	public static void complexExpression() {
		class Main {}
		class Sub extends Main {}
		
		System.out.println(new Sub() instanceof Main);
		System.out.println(new Sub() instanceof Sub);
		System.out.println(new Main() instanceof Sub);
	}
	
	public static void moreComplexExpression() {
		
	}
	
	public static void main(String[] args) {
//		simpleExpression();
		complexExpression();
	}
}
