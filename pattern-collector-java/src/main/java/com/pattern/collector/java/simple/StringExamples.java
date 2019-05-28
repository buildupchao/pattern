package com.pattern.collector.java.simple;

/**
 * String案例
 * @author buildupchao
 * @date 2019/05/28 11:19
 * @since JDK 1.8
 */
public class StringExamples {

	public static void main(String[] args) {
		testMemoryAddressEqual();
		testNewObjectMemoryAddressEqual();
		testIfWillChangeValue();
		testValueEqual();
	}

	/*
	 * 内存地址比较（用于判断是否是同一个对象）:s1 == s2
	 * 对象值比较：s1.equals(s2)
	 */
	private static void testMemoryAddressEqual() {
		String s1 = "buildupchao";
		String s2 = "buildupchao";
		System.out.printf("testMemoryAddressEqual>s1 == s2: %b\n", s1 == s2);
		System.out.printf("testMemoryAddressEqual>s1.equals(s2): %b\n", s1.equals(s2));
	}
	
	/*
	 * 检验对象内存地址、值是否一样。
	 */
	private static void testNewObjectMemoryAddressEqual() {
		String s1 = new String("buildupchao");
		String s2 = "buildupchao";
		System.out.printf("testNewObjectMemoryAddressEqual>s1 == s2: %b\n", s1 == s2);
		System.out.printf("testNewObjectMemoryAddressEqual>s1.equals(s2): %b\n", s1.equals(s2));
	}
	
	/*
	 * 检验值是否会被改变
	 */
	private static void testIfWillChangeValue() {
		String s1 = "buildupchao";
		changeValue(s1);
		System.out.printf("testIfWillChangeValue>s1: %s\n", s1);
		
		String s2 = new String("buildupchao");
		changeValue(s2);
		System.out.printf("testIfWillChangeValue>s2: %s\n", s2);
	}
	
	private static void changeValue(String str) {
		str = "new value";
	}
	
	/*
	 * 比对对象值是否相等
	 */
	private static void testValueEqual() {
		String s1 = "A" + "B";
		String s2 = "AB";
		String s3 = "A".concat("B");
		String s4 = new String("AB");
		String s5 = String.valueOf("AB");
		System.out.printf("testValueEqual>s1 == s2: %b\n", s1 == s2);
		System.out.printf("testValueEqual>s1.equals(s2): %b\n", s1.equals(s2));
		
		System.out.printf("testValueEqual>s1 == s3: %b\n", s1 == s3);
		System.out.printf("testValueEqual>s1.equals(s3): %b\n", s1.equals(s3));
		
		System.out.printf("testValueEqual>s1 == s4: %b\n", s1 == s4);
		System.out.printf("testValueEqual>s1.equals(s4): %b\n", s1.equals(s4));
		
		System.out.printf("testValueEqual>s1 == s5: %b\n", s1 == s5);
		System.out.printf("testValueEqual>s1.equals(s5): %b\n", s1.equals(s5));
		
		System.out.printf("testValueEqual>s3 == s5: %b\n", s3 == s5);
		System.out.printf("testValueEqual>s3.equals(s5): %b\n", s3.equals(s5));
	}
}
