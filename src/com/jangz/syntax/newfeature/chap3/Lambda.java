package com.jangz.syntax.newfeature.chap3;

public class Lambda {
	
	public static void main(String[] args) {
		lambdaExpression();
	}
	
	public static void lambdaExpression() {
		Runnable r1, r2;
		r1 = () -> System.out.println("Hello World 1");
		r2 = () -> System.out.println("Hello World 2");
		
		process(r1);
		process(r2);
		process(() -> System.out.println("Hello World 3"));
	}
	
	public static void process(Runnable r) {
		r.run();
	}
}
