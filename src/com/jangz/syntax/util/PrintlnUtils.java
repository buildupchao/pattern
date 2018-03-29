package com.jangz.syntax.util;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class PrintlnUtils {

	public static void println(Object o) {
		System.out.println(o);
	}
	
	public static <T> void println(List<T> list) {
		if (CollectionUtils.isNotEmpty(list))
			list.stream().forEach(el -> System.out.println(el));
	}
}
