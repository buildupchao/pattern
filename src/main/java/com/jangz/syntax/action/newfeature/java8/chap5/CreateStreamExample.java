package com.jangz.syntax.action.newfeature.java8.chap5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import com.jangz.syntax.action.newfeature.java8.entity.Pair;

public class CreateStreamExample {

	private static final String BASE_PATH = "src/com/jangz/newfeature/chap5";

	public static void main(String[] args) {
/*		createStreamFromFile();

		iterate();*/
		
		generateFabinace();
		
		generate();
	}

	public static void createStreamFromFile() {
		String data_path = BASE_PATH + "/data.txt";
		long uniqueWords = 0;
		try (Stream<String> lines = Files.lines(Paths.get(data_path), Charset.defaultCharset())) {
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
			System.out.println(uniqueWords);
		} catch (IOException e) {

		}
	}

	public static void iterate() {
		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
	}

	public static void generateFabinace() {
		Stream.iterate(new Pair<Integer>(0, 1), pair -> new Pair<Integer>(pair.getY(), pair.sum()))
				.limit(20).map(Pair::getX).forEach(x -> System.out.print(x + ", "));
		System.out.println();
	}
	
	public static void generate() {
		Stream.generate(Math::random).limit(5).forEach(System.out::println);
	}
}
