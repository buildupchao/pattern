package com.pattern.tutor.syntax.action.newfeature.java8.lambda;

import java.util.Map;

import com.google.common.collect.Maps;
import com.pattern.common.utils.PrintlnUtils;

public class MapReplaceAllExample {

	public static void main(String[] args) {
//		new MapReplaceAllExample().repleaceAll();
		new MapReplaceAllExample().concatAll();
	}
	
	public void repleaceAll() {
		String str = "alpha-bravo-charlie"; 
		Map<String, String> map = Maps.newHashMap();
		map.put("alpha", "X");
		map.put("bravo", "Y");
		map.put("charlie", "Z");
		map.replaceAll(str::replace);
		map.forEach((key, value) -> PrintlnUtils.println(key + "=" + value));
	}
	
	public void concatAll() {
		Map<String, String> map = Maps.newHashMap();
		map.put("alpha", "X");
		map.put("bravo", "Y");
		map.put("charlie", "Z");
		map.replaceAll(String::concat);
		map.forEach((key, value) -> PrintlnUtils.println(key + "=" + value));
	}
}
