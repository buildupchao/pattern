package com.jangz.syntax.newfeature.lambda.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.jangz.syntax.util.PrintlnUtils;

public class WordCount {

	public static void main(String[] args) {
		String current = System.getProperty("user.dir") + "/src/com/jangz/syntax/newfeature/lambda/examples";
		try {
			MapReduce mapreduce = new MapReduce();
			Stream<Character> charStream = Files.readAllLines(Paths.get(current + "/data.txt"))
				.stream()
				.flatMap(line -> IntStream.range(0, line.length()).mapToObj(line::charAt));
			int total = mapreduce.count(charStream);
			PrintlnUtils.println(total);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
