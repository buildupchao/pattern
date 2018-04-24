package com.pattern.tutor.deepinjvm.classloader;

public class ClassLoaderExample {
	public static void main(String[] args) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		System.out.println(classLoader);
		System.out.println(classLoader.getParent() + " -> " + classLoader.getParent().getClass().getName());
		System.out.println(classLoader.getParent().getParent());
	}
}
