package com.pattern.common.utils;

import java.io.*;
import java.util.Properties;

/**
 * @author buildupchao
 * @date 2019/07/25 13:04
 * @since JDK 1.8
 */
public class PropertyUtil {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String workspace = System.getProperty("user.dir") + "/pattern-common/src/main/resources/test.properties";

		System.out.println(workspace);
		Properties properties = new Properties();
		properties.load(new InputStreamReader(new FileInputStream(workspace), "UTF-8"));
		System.out.println(properties.get("values"));
	}
}
