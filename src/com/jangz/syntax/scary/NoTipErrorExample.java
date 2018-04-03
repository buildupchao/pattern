package com.jangz.syntax.scary;

/**
 * 
 * @see
 *
 * @author jangz
 * @since
 */
public class NoTipErrorExample {
	
	public static void main(String[] args) {
		int v1 = 1_073_741_827;
		int v2 = 1_431_655_768;
		System.out.println("v1=" + v1);
		System.out.println("v2=" + v2);
		
		int average = (v1 + v2) / 2;
		System.out.println("average of " + v1 + ", " + v2 + " is " + average);
	}
}
/*
	v1=1073741827
	v2=1431655768
	average of 1073741827, 1431655768 is -894784850
 */