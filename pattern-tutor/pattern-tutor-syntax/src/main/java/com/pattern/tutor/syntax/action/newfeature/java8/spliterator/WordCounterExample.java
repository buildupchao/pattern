package com.pattern.tutor.syntax.action.newfeature.java8.spliterator;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WordCounterExample {
	
	private static final String SENTENCES = "Whatever you're building, these guides are designed to get you productive as quickly as possible – using the latest Spring project releases and techniques as recommended by the Spring team.";
	
	public static void main(String[] args) {
		Stream<Character> stream = IntStream.range(0, SENTENCES.length()).mapToObj(SENTENCES::charAt);
		int counter = new WordCounterExample().countWords(stream);
		System.out.println(counter);
	}
	
	public int countWords(Stream<Character> stream) {
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
		return wordCounter.getCounter();
	}
}
