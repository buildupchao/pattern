package com.jangz.pattern.decorator;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

public class CharacterInputStreamTest {

	private static final Logger log = Logger.getLogger("CharacterInputStream");

	public static void main(String[] args) {
		int c;
		String env = System.getProperty("user.dir");
		String testFilePath = env + File.separator + "src/com/jangz/pattern/decorator/test2.txt";
		
		CharacterInputStream in = null;
		try {
			in = new CharacterInputStream(
					new BufferedInputStream(new FileInputStream(testFilePath)));
			
			StringBuffer buffer = new StringBuffer("");
			while ((c = in.read()) != -1) {
				if (c != 0) {
					buffer.append((char) c);
				}
			}
			log.info("The character serial is " + buffer.toString());
		} catch (FileNotFoundException e) {
			log.warning("File read throw FileNotFoundException");
		} catch (IOException e) {
			log.warning("IO read throw IOException");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				log.warning("Close IO throw IOException");
			}
		}
	}

}
