package com.pattern.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintlnUtils {
	
	private static final String DEFAULT_PACKAGE = "com/jangz/utils/logs.log";
	private static final String DEFAULT = System.getProperty("user.dir") + File.separator + DEFAULT_PACKAGE;
	
	public static void println(Object content) {
		log.info("content={}", content);
	}
	
	public static void fprintln(String content) {
		try {
			FileOutputStream out = new FileOutputStream(new File(DEFAULT), true);
			out.write((content + "\n").getBytes());
			out.flush();
			out.close();
		} catch (IOException e) {
			log.error("PrintlnUtils#fprintln", e);
		}
	}
	
	public static <T> void println(List<T> list) {
		if (CollectionUtils.isNotEmpty(list))
			list.stream().forEach(el -> System.out.println(el));
	}
	
	public static <T> void println(Collection<T> col) {
		if (CollectionUtils.isNotEmpty(col))
			col.stream().forEach(System.out::println);
	}
}
