package com.jangz.newfeature.chap3.executearound;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {

	private static final String BASE_PATH = "src/com/jangz/newfeature/chap3/executearound";
	
	public static void main(String[] args) throws IOException {
//		System.out.println(processFile());
		
		System.out.println(processFile((in) -> in.readLine() + "\n" + in.readLine()));
	}

	public static String processFile() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(BASE_PATH + "/data.txt"))) {
			return br.readLine();
		}
	}
	
	public static String processFile(BufferedReaderProcessor processor) throws IOException {
		try (BufferedReader in = new BufferedReader(new FileReader(BASE_PATH + "/data.txt"))) {
			return processor.process(in);
		}
	}
}
