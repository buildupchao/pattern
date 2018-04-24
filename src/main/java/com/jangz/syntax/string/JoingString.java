package com.jangz.syntax.string;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Splitter;
import com.jangz.utils.PrintlnUtils;

public class JoingString {
	
	public static void main(String[] args) {
//		splitUsingJDK();
//		splitUsingGuava();
//		splitUsingStringUtils();
//		splitUsingStringUtilsFromSpring();
//		joiningUsingGuava();
		joiningUsingSpring();
	}
	
	private static void splitUsingJDK() {
		String str = "a,b,c";
		List<String> result = Arrays.asList(str.split(","));
		PrintlnUtils.println(result);
	}
	
	private static void splitUsingGuava() {
		String str = "a, b, c";
		List<String> result = Splitter.on(",").trimResults().splitToList(str);
		PrintlnUtils.println(result);
	}
	
	private static void splitUsingStringUtils() {
		String str = "a,b,c";
		List<String> result = Arrays.asList(StringUtils.split(str, ","));
		PrintlnUtils.println(result);
	}
	
	private static void splitUsingStringUtilsFromSpring() {
		String str = "a,b,c";
		List<String> result = Arrays.asList(org.springframework.util.StringUtils.commaDelimitedListToStringArray(str));
		PrintlnUtils.println(result);
	}
	
	private static void joiningUsingGuava() {
		List<String> list = Arrays.asList("a", "b", "c");
		String str = StringUtils.join(list.toArray(), ",");
		PrintlnUtils.println(str);
	}
	
	private static void joiningUsingSpring() {
		List<String> list = Arrays.asList("a", "b", "c");
		String str = org.springframework.util.StringUtils.collectionToCommaDelimitedString(list);
		PrintlnUtils.println(str);
	}
}
