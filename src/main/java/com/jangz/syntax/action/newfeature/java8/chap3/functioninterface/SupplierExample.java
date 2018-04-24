package com.jangz.syntax.action.newfeature.java8.chap3.functioninterface;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.jangz.syntax.action.newfeature.java8.util.factory.StringFactory;

public class SupplierExample {
	
	public static void main(String[] args) {
		Random rand = new Random();
		supply(StringFactory.generateStringList(), () -> new Integer(rand.nextInt())).stream().forEach(System.out::println);;
	}
	
	public static <T> List<T> supply(List<String> list, Supplier<T> s) {
		return list.stream().map((str) -> s.get()).collect(Collectors.toList());
	}
}
