package com.pattern.offer.microsoft;

public class CPUTime {
	
	private static final double TIME = 1000;
	
	public static void main(String[] args) throws InterruptedException {
		double x = 0;
		double y = 0;
		
		while (true) {
			y = (Math.sin(x) + 1) * TIME / 2;
			doSomeWork(y);
			x += 0.1;
			Thread.sleep((long) (TIME - y));
		}
	}
	
	private static void doSomeWork(double y) {
		long startTime = System.currentTimeMillis();
		
		while ((System.currentTimeMillis() - startTime) < y) {
			
		}
	}
}
