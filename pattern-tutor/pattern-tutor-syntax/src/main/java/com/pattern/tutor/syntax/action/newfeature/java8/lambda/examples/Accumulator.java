package com.pattern.tutor.syntax.action.newfeature.java8.lambda.examples;

import java.util.function.BiFunction;

public class Accumulator implements BiFunction<Tuple, Character, Tuple> {

	@Override
	public Tuple apply(Tuple last, Character currentChar) {
		if (Character.isWhitespace(currentChar)) {
			return new Tuple(true, last.getCounter());
		} else {
			return last.isLastSpace() ? new Tuple(false, last.getCounter() + 1) : new Tuple(false, last.getCounter());
		}
	}

}
