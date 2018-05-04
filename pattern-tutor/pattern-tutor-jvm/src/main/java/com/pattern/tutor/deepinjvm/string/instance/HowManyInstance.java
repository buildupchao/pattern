package com.pattern.tutor.deepinjvm.string.instance;

public class HowManyInstance {
	
	public static void main(String[] args) {
		String str1 = new String("xyz");
		String str2 = new String("xyz");
		String str3 = "xyz";
		String str4 = new String(str1);
		String str5 = str1.concat("");
		String str6 = str1.concat("k");
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str2 == str3);
		System.out.println(str4 == str1);
		System.out.println(str5 == str1);
		System.out.println(str6 == (str1 + "k"));
	}
}
