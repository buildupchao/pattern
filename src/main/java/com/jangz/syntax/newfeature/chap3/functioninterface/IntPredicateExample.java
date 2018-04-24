package com.jangz.syntax.newfeature.chap3.functioninterface;

import java.util.function.Predicate;

public class IntPredicateExample {
	
	public static void main(String[] args) {
		
		IntPredicate evenNumbers = (int i) -> i % 2 == 0;
		System.out.println(evenNumbers.test(1000));
		
		Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
		System.out.println(oddNumbers.test(1000));
	}
}
