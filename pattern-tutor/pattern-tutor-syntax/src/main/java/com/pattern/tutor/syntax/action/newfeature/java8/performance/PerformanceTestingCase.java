package com.pattern.tutor.syntax.action.newfeature.java8.performance;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PerformanceTestingCase {

	public static long measureSumPer(Function<Long, Long> adder, long n) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start) / 1_000_000;
			System.out.println("Result: " + sum);
			if (duration < fastest) {
				fastest = duration;
			}
		}
		return fastest;
	}

	public static long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
	}

	public static long iterativeSum(long n) {
		long result = 0;
		for (long i = 1L; i <= n; i++) {
			result += i;
		}
		return result;
	}

	public static long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
	}
	
	public static long wrapperSum(long n) {
		return LongStream.rangeClosed(0L, n).summaryStatistics().getSum();
	}
	
	public static long simpleSum(long n) {
		return LongStream.rangeClosed(0L, n).sum();
	}

	public static void main(String[] args) {
		System.out
				.println("Sequential sum done in: " + measureSumPer(PerformanceTestingCase::sequentialSum, 10_000_000));
		System.out
			.println("Iterative sum done in: " + measureSumPer(PerformanceTestingCase::iterativeSum, 10_000_000));
		System.out
			.println("ParallelStream sum done in: " + measureSumPer(PerformanceTestingCase::parallelSum, 10_000_000));
		System.out
			.println("Wrapper sum done in: " + measureSumPer(PerformanceTestingCase::wrapperSum, 10_000_000));
		System.out
			.println("Simple sum done in: " + measureSumPer(PerformanceTestingCase::simpleSum, 10_000_000));
	}
}
