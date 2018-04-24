package com.pattern.tutor.syntax.action.newfeature.java8.chap3.functioninterface;

import java.util.function.DoubleFunction;

public class IntegrateFunctionExample {
	
	public static void main(String[] args) {
		System.out.println(integrate((double x) -> x + 10, 3, 7));
	}
	
	public static double integrate(DoubleFunction<Double> f, double a, double b) {
		return (f.apply(a) + f.apply(b)) * (b - a) / 2.0;
	}
}
