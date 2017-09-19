package com.jangz.adviceoof;

public class DoNotUseConfuseVar {
	
	public static void main(String[] args) {
		long i = 1l; // let long i = 1L;
		System.out.println("Double i: " + (i + i));
	}
	
}
