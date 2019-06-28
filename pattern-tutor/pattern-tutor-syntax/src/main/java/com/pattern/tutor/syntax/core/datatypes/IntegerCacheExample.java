package com.pattern.tutor.syntax.core.datatypes;

import java.util.Objects;

/**
 * If a new Integer instance is not required, this method should 
 * generally be used in preference to the constructor Integer(int), 
 * as this method is likely to yield significantly better space 
 * and time performance by caching frequently requested values.
 * 
 * Created by jangz on 2017/11/22
 */
public class IntegerCacheExample {
	
	public static void main(String[] args) {
		Integer integer = new Integer(128);
		Integer integer2 = new Integer(128);
		System.out.printf("Objects.equals(integer, integer2): %b\n", Objects.equals(integer, integer2)); // true
		System.out.printf("integer == integer2: %b\n", integer == integer2); // false
		
		Integer int128 = Integer.valueOf(128);
		Integer integer128 = Integer.valueOf(128);
		System.out.printf("int128.equals(integer128): %b\n", int128.equals(integer128)); // true
		System.out.printf("int128 == integer128: %b\n", int128 == integer128); // false
		
		Integer integer126 = new Integer(126);
		Integer int126 = new Integer(126);
		System.out.printf("integer126 == int126: %b\n", integer126 == int126); // false
		System.out.printf("integer126.equals(int126): %b\n", integer126.equals(int126)); // true
		
		Integer int127 = Integer.valueOf(127);
		Integer integer127 = Integer.valueOf(127);
		System.out.printf("int127 == integer127: %b\n", int127 == integer127); // true
		System.out.printf("integer127.equals(int127): %b\n", integer127.equals(int127)); // true
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		System.out.printf("str1.equals(str2): %b\n", str1.equals(str2)); // true
	}
	
}
