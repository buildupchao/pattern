package com.pattern.tutor.deepinjvm.string.instance;

public class ConcatSpecial {
	public static void main(String[] args) {
		String s1 = "z";
		String s2 = s1.concat("");
		String s3 = s1.concat("y");
		String s4 = null;
	}
}
