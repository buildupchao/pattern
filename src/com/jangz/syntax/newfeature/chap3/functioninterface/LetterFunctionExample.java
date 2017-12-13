package com.jangz.syntax.newfeature.chap3.functioninterface;

import java.util.function.Function;

import com.jangz.syntax.newfeature.entity.Letter;

public class LetterFunctionExample {

	public static void main(String[] args) {
		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
				.andThen(Letter::addFooter);

		Function<String, String> simpleTransformationPipeline = addHeader.andThen(Letter::addFooter);

		String text = "Thank you so much! I had got many labda skills from you.";
		
		System.out.println(transformationPipeline.apply(text));
		System.out.println(simpleTransformationPipeline.apply(text));
	}
}
