package com.pattern.tutor.syntax.action.newfeature.java8.util.factory;

import java.util.Arrays;
import java.util.List;

public class StringFactory {
	
	public static List<String> generateStringList() {
		return Arrays.asList("jangz", "Zychaowill", "", "Jang Zhang", "");
	}
	
	public static List<String> generateSingleCharacterList() {
		return Arrays.asList("a", "b", "A", "B");
	}
	
	public static List<String> generateTermList() {
		return Arrays.asList("Java8", "In", "Action");
	}
}
