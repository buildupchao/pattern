package com.jangz.syntax.newfeature.lambda.examples;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.jangz.utils.PrintlnUtils;

public class SimpleWordCount {

	public static void main(String[] args) throws IOException {
		String current = System.getProperty("user.dir") + "/src/com/jangz/syntax/newfeature/lambda/examples";
		Map<String, Long> mapper = Files.readAllLines(Paths.get(current + "/data.txt"))
			.stream()
			.flatMap(line -> Arrays.stream(line.split(" ")))
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		StringBuilder buffer = new StringBuilder("");
		mapper.forEach((key, value) -> {
			PrintlnUtils.println(key + "," + value);
			buffer.append(key).append(",").append(value).append("\n");
		});
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(current + "/_result")));
		writer.write(buffer.toString());
		writer.flush();
		writer.close();
	}
}
