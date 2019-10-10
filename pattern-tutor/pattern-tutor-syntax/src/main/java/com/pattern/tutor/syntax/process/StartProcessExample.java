package com.pattern.tutor.syntax.process;

import java.io.BufferedReader;
import java.io.IOException;

import jline.internal.InputStreamReader;

public class StartProcessExample {
	public static void main(String[] args) throws IOException, InterruptedException {
		Process process = null;
		
		String command = "python D:\\demo.py";
		process = Runtime.getRuntime().exec(command);
		
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		in.close();
		process.waitFor();
		System.out.println("DONE");
	}
}
