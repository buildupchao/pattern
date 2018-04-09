package com.jangz.syntax.newfeature.lambda;

import java.util.Map;

import com.google.common.collect.Maps;
import com.jangz.utils.PrintlnUtils;

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
