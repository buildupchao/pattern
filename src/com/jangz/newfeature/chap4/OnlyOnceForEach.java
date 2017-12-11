package com.jangz.newfeature.chap4;

import java.util.List;
import java.util.stream.Stream;

import com.jangz.newfeature.util.factory.StringFactory;

public class OnlyOnceForEach {
	
	public static void main(String[] args) {
		List<String> title = StringFactory.generateTermList();
		Stream<String> stream = title.stream();
		stream.forEach(System.out::println);
		/*
		 *  java.lang.IllegalStateException: stream has already been operated upon or closed
		 */
		stream.forEach(System.out::println);
	}
}