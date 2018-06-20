package com.pattern.tutor.syntax.test.simple;

import java.util.Objects;

/**
 * If a new Integer instance is not required, this method should 
 * generally be used in preference to the constructor Integer(int), 
 * as this method is likely to yield significantly better space 
 * and time performance by caching frequently requested values.
 * 
 * Created by jangz on 2017/11/22
 */
public class IntegerCacheTest {
	
	public static void main(String[] args) {
		Integer integer = new Integer(128);
		Integer integer2 = new Integer(128);
		System.out.println(Objects.equals(integer, integer2));
		System.out.println(integer == integer2);
		
		Integer.valueOf(128);
		System.out.println(integer.equals(integer2));
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		System.out.println(str1.equals(str2));
	}
	
}
