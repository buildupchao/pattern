package com.jangz.pattern.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {

	public static void main(String[] args) {
		int c = -1;
		try {
			InputStream in = new LowerCaseInputStream(
					new BufferedInputStream(new FileInputStream("D:/jangz/workspace/JavaPro/src/com/jangz/pattern/decorator/test.txt")));

			while ((c = in.read()) != -1) {
				System.out.print((char) c);
			}
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
