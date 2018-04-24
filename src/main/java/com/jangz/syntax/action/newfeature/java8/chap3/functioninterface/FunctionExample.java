package com.jangz.syntax.action.newfeature.java8.chap3.functioninterface;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.jangz.syntax.action.newfeature.java8.util.factory.IntegerFactory;
import com.jangz.syntax.action.newfeature.java8.util.factory.StringFactory;

public class FunctionExample {

	public static void main(String[] args) {
		map(StringFactory.generateStringList(), (String s) -> s.length()).forEach(System.out::println);
		System.out.println("------------------------------------");
		
		andThen(IntegerFactory.generateIntegerList(), x -> x + 1, x -> x * 2);
		System.out.println("------------------------------------");
		
		compose(IntegerFactory.generateIntegerList(), x -> x + 1, x -> x * 2);
		System.out.println("------------------------------------");
	}

	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		return list.stream().map(f).collect(Collectors.toList());
	}
	
	public static <T, R, V> void andThen(List<T> list, Function<T, R> f, Function<R, V> g) {
		Function<T, V> h = f.andThen(g);
		list.stream().forEach(t -> {
			System.out.println(t + " -> " + h.apply(t));
		});
	}
	
	public static <T, R, V> void compose(List<T> list, Function<R, V> f, Function<T, R> g) {
		Function<T, V> h = f.compose(g);
		list.stream().forEach(t -> {
			System.out.println(t + " -> " + h.apply(t));
		});
	}
}
