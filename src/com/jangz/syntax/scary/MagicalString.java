package com.jangz.syntax.scary;

import java.io.UnsupportedEncodingException;

public class MagicalString {
	
	public static void main(String[] args) {
//		basicExpression();
//		charsetExpression();
//		specialExpression();
//		advanceExpression();
		moreAdvancedExpression();
	}
	
	public static void basicExpression() {
		String s1 = "abc";
		StringBuffer s2 = new StringBuffer(s1);
		System.out.println(s1.equals(s2)); // false
		
		StringBuffer s3 = new StringBuffer("abc");
		System.out.println(s3.equals("abc")); // false
		System.out.println(s3.toString().equals("abc")); // true
	}
	
	public static void charsetExpression() {
		try {
			String s1 = "你好";
			String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
			System.out.printf("s2=%s", s2);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static void specialExpression() {
		String s1 = "a";
		String s2 = s1.concat("");
		String s3 = null;
		new String(s1);
		System.out.println(s1 == s2);
		
		// 运行时的类加载过程与实际执行某个代码片段，两者必须分开讨论才有那么点意义
		/**
		 * 合规范的JVM实现应该在类加载的过程中创建并驻留一个String实例作为常量来对应"xyz"字面量；
		 * 具体是在类加载的resolve阶段进行的。这个常量是全局共享的，只在先前尚未有内容相同的字符串
		 * 驻留过的前提下才需要创建新的String实例。
		 */
		String s4 = new String("xyz");
		String s5 = new String("xyz");
		System.out.println(s4 == s5);
	}
	
	public static void advanceExpression() {
		String str1 = "s1";
		String str2 = "s" + 1;
		System.out.println("str1 == str2: " + (str1 == str2)); // true
		
		String str3 = "ab";
		String str4 = "b";
		String str5 = "a" + str4;
		System.out.println("str3 == str5: " + (str3 == str5)); // false
		
		final String str6 = "b";
		String str7 = "a" + str6;
		System.out.println("str3 == str7: " + (str3 == str7)); // true
		
		final String str8 = getB();
		String str9 = "a" + str8;
		System.out.println("str3 == str9: " + (str3 == str9)); // false
	}
	
	private static String getB() {
		return "b";
	}
	
	public static void moreAdvancedExpression() {
		String str1 = "ab";
		String str2 = "a";
		String str3 = "b";
		String str4 = str2 + str3;
		System.out.println("str4 == str1: " + (str4 == str1)); // false
		System.out.println("str4.intern() == str1: " + (str4.intern() == str1)); // true
		System.out.println("str4 == str1.intern(): " + (str4 == str1.intern())); // false
		System.out.println("str4.intern() == str1.intern(): " + (str4.intern() == str1.intern())); // true
	}
}
