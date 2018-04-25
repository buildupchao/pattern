package com.pattern.tutor.deepinjvm.load;

public class CustomClassLoaderExample {

	public static void main(String[] args) {
		CustomClassLoader classLoader = new CustomClassLoader();
		classLoader.setRoot("D:/jangz/git/projects/pattern/pattern-tutor/pattern-tutor-syntax/src/main/java/");
		
		Class<?> testClass = null;
		try {
			testClass = classLoader.loadClass("com.pattern.tutor.syntax.scary.ScaryExpressionExample");
			Object instance = testClass.newInstance();
			System.out.printf("ClassLoader is %s.\n", instance.getClass().getClassLoader());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
