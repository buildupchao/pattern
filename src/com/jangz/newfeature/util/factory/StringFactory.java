package com.jangz.newfeature.util.factory;

import java.util.Arrays;
import java.util.List;

public class StringFactory {
	
	public static List<String> generateStringList() {
		return Arrays.asList("jangz", "Zychaowill", "", "Jang Zhang", "");
	}
	
	public static List<String> generateSingleCharacterList() {
		return Arrays.asList("a", "b", "A", "B");
	}
}
