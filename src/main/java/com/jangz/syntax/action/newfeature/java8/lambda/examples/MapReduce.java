package com.jangz.syntax.action.newfeature.java8.lambda.examples;

import java.util.stream.Stream;

public class MapReduce {


	public int count(Stream<Character> charStream) {
		Tuple t = charStream.reduce(new Tuple(true, 0), new Accumulator(), new Combiner());
		return t.getCounter();
	}
}
