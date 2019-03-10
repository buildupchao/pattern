package com.pattern.tutor.syntax.action.newfeature.java8.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.junit.Test;

import com.pattern.tutor.syntax.action.newfeature.java8.completablefuture.examples.DelayUtils;

public class CompletableFutureAdvancedExample {

	@Test
	public void testThenApplyAndComposite() {
		long start = System.nanoTime();
		String result = CompletableFuture.supplyAsync(() -> {
			DelayUtils.delay();
			return "buildupchao";
		}).thenApply(name -> {
			return new Random(100000).nextDouble() * name.charAt(0) + name.charAt(1);
		}).thenCompose(value -> CompletableFuture.supplyAsync(() -> {
			DelayUtils.delay(3);
			return String.format("The value of your name is: %s", value);
		})).join();
		long cost = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Cost time: " + cost);
		System.out.println(result);
		System.out.println("DONE");
	}
	
	@Test
	public void testThenCombine() {
		long start = System.nanoTime();
		CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> {
			DelayUtils.delay();
			return 13.0;
		}).thenCombine(CompletableFuture.supplyAsync(() -> {
			DelayUtils.delay(3);
			return 7;
		}), (a, b) -> a * b);
		
		Double result = future.join();
		long cost = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Cost time: " + cost);
		System.out.println(result);
		System.out.println("DONE");
	}
}
