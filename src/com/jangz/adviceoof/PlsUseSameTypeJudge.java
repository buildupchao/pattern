package com.jangz.adviceoof;

public class PlsUseSameTypeJudge {
	
	public static void main(String[] args) {
		int i = 80;
		String s = String.valueOf(i < 100 ? 90 : 100);
		String s1 = String.valueOf(i < 100 ? 90 : 100.0);
		System.out.println("Are s and s1 equal? : " + s.equals(s1)); // false
	}
}
