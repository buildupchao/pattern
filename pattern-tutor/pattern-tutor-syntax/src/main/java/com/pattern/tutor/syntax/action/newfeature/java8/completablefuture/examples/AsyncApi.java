package com.pattern.tutor.syntax.action.newfeature.java8.completablefuture.examples;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.junit.Test;

public class AsyncApi {
	
	@Test
	public void testGetPriceAsync() {
		Shop shop = new Shop("BestPrice");
		long start = System.nanoTime();
//		Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
		Future<Double> futurePrice = shop.newPriceAsync("my favorite product");
		long invocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Invocation returned after " + invocationTime + " msecs");
		
		try {
			double price = futurePrice.get();
			System.out.printf("Price is %.2f%n", price);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Price returned after " + retrievalTime + " msecs");
	}
	
	@Test
	public void testFindPricesByMultiMethod() {
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"), new Shop("LetsSaveBig"), new Shop("MyFavoriteShop"), new Shop("BuyItAll"), new Shop("VirtualShop"),
				new Shop("VirtualShop2"), new Shop("VirtualShop3"), new Shop("VirtualShop4"), new Shop("VirtualShop5"));
		long start = System.nanoTime();
		
		// Pls replace it with kinds of methods
		System.out.println(findPricesUsingCompletableFuture(shops, "myPhone27S"));
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + " msecs");
	}
	
	private List<String> findPrices(List<Shop> shops, String product) {
		return shops
				.stream()
//				.parallelStream()
				.map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
				.collect(Collectors.toList());
	}
	
	private List<String> findPricesUsingCompletableFuture(List<Shop> shops, String product) {
		List<CompletableFuture<String>> priceFutures = shops
			.stream()
			.map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))
			.collect(Collectors.toList());
		return priceFutures.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());
	}
}
