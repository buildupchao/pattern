package com.jangz.syntax.scary;

public class MagicalWrapper {
	public static void main(String[] args) {
//		basicExpression();
		specialExpression();
	}
	
	public static void basicExpression() {
		Integer i1 = 100;
		Integer i2 = 100;
		Integer i3 = 200;
		Integer i4 = 200;
		System.out.println(i1 == i2); // true
		System.out.println(i3 == i4); // false

		Double d1 = 100.0;
		Double d2 = 100.0;
		Double d3 = 200.0;
		Double d4 = 200.0;
		System.out.println(d1 == d2); // false
		System.out.println(d3 == d4); // false

		Boolean b1 = false;
		Boolean b2 = false;
		Boolean b3 = true;
		Boolean b4 = true;
		System.out.println(b1 == b2); // true
		System.out.println(b3 == b4); // true

		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		Long h = 2L;
		System.out.println(c == d); // true
		System.out.println(e == f); // false
		System.out.println(c == (a + b)); // true
		System.out.println(c.equals(a + b)); // true
		System.out.println(g == (a + b)); // true
		System.out.println(g.equals(a + b)); // false
		System.out.println(g.equals(a + h)); // true

		Integer k1 = 444;
		int k2 = 444;
		System.out.println(k1 == k2); // true
		System.out.println(k1.equals(k2)); // true
	}

	public static void specialExpression() {
		Integer i1 = new Integer(127);
		Integer i2 = new Integer(127);
		System.out.println((i1 == i2)); // false
		System.out.println(i1.equals(i2)); // true

		Integer i3 = new Integer(128);
		Integer i4 = new Integer(128);
		System.out.println(i3 == i4); // false
		System.out.println(i3.equals(i4)); // true
		
		Integer i5 = 128;
		Integer i6 = 128;
		System.out.println(i5 == i6); // false 
		System.out.println(i5.equals(i6)); // true
		    
		Integer i7 = 127;
		Integer i8 = 127;
		System.out.println(i7 == i8); // true
		System.out.println(i7.equals(i8)); // true
	}
}
