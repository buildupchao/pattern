package com.pattern.tutor.syntax.action.newfeature.java8.lambda.examples;

import java.util.function.BinaryOperator;

public class Combiner implements BinaryOperator<Tuple> {

	@Override
	public Tuple apply(Tuple t, Tuple u) {
		return new Tuple(t.isLastSpace(), t.getCounter() + u.getCounter());
	}

}
