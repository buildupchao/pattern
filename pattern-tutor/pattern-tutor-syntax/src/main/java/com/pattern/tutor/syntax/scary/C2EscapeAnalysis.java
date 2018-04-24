package com.pattern.tutor.syntax.scary;

public class C2EscapeAnalysis {
	private static void warmUp() {
		IFoo[] array = new IFoo[] { new FooA(), new FooB(), new FooC(), new FooD() };
		for (int i = 0; i < 1000000; i++) {
			array[i % array.length].foo(); // megamorphic callsite to prevent
											// inlining
		}
	}

	public static void main(String[] args) {
		while (true) {
			warmUp();
		}
	}
}

interface IFoo {
	void foo();
}

class FooA implements IFoo {
	public void foo() {
		String s1 = new String("xyz");
	}
}

class FooB implements IFoo {
	public void foo() {
		String s1 = new String("xyz");
		String s2 = new String("xyz");
	}
}

class FooC implements IFoo {
	public void foo() {
		String s1 = new String("xyz");
		String s2 = new String("xyz");
		String s3 = new String("xyz");
	}
}

class FooD implements IFoo {
	public void foo() {
		String s1 = new String("xyz");
		String s2 = new String("xyz");
		String s3 = new String("xyz");
		String s4 = new String("xyz");
	}
}