package com.jangz.adviceoof;

import java.util.Random;

public class DoNotLetFinalToVar {
	
	public static void main(String[] args) {
		System.out.println("RAND_CONST_1: " + Const.RAND_CONST);
		System.out.println("RAND_CONST_2: " + Const.RAND_CONST);
		System.out.println("RAND_CONST_3: " + Const.RAND_CONST);
		System.out.println("RAND_CONST_4: " + Const.RAND_CONST);
		System.out.println("RAND_CONST_5: " + Const.RAND_CONST);
	}
}

interface Const {
	public static final int RAND_CONST = new Random().nextInt();
}
