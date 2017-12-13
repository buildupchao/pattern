package com.jangz.syntax.newfeature.chap3.functioninterface;

import java.util.List;
import java.util.function.Consumer;

import com.jangz.syntax.newfeature.util.factory.IntegerFactory;

public class ConsumerExample {
	
	public static void main(String[] args) {
		forEach(IntegerFactory.generateIntegerList(), (Integer i) -> System.out.print(i + "\t"));
	}

	public static <T> void forEach(List<T> list, Consumer<T> c) {
		list.stream().forEach(c);
	}
}
