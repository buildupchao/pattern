package com.pattern.common.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author buildupchao
 * @date 2019/07/25 13:04
 * @since JDK 1.8
 */
public class PropertyUtil {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		InputStream in = PropertyUtil.class.getClassLoader().getResourceAsStream("src/main/resources/test.properties");
		Properties properties = new Properties();
		properties.load(new InputStreamReader(in, "UTF-8"));
		System.out.println(properties.get("values"));
	}
}
