package com.pattern.tutor.syntax.action.newfeature.java8.completablefuture.examples;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import lombok.Getter;

@Getter
public class Shop {

	private String name;

	public Shop(String name) {
		super();
		this.name = name;
	}

	public double getPrice(String product) {
		return calculatePrice(product);
	}
	
	public Future<Double> newPriceAsync(String product) {
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}

	public Future<Double> getPriceAsync(String product) {
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		new Thread(() -> {
			try {
				double price = calculatePrice(product);
				futurePrice.complete(price);
			} catch (Exception ex) {
				futurePrice.completeExceptionally(ex);
			}
		}).start();
		return futurePrice;
	}

	private double calculatePrice(String product) {
		DelayUtils.delay();
		return new Random(100).nextDouble() * product.charAt(0) + product.charAt(1);
	}
}
