package com.pattern.tutor.syntax.action.newfeature.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureSimpleExample {
	
	public static void main(String[] args) {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> doWorkUsingLongTime());
		System.out.println("Waiting");
		try {
			String result = future.get(10, TimeUnit.SECONDS);
			System.out.println(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	private static String doWorkUsingLongTime() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "DONE";
	}
}
