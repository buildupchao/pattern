package com.jangz.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
}
