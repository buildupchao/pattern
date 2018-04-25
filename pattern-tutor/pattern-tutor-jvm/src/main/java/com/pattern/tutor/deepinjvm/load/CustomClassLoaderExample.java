package com.pattern.tutor.deepinjvm.load;

public class CustomClassLoaderExample {

	public static void main(String[] args) {
		CustomClassLoader classLoader = new CustomClassLoader();
		classLoader.setRoot("D:\\jangz\\git\\vm");
		
		Class<?> testClass = null;
		try {
			testClass = classLoader.loadClass("com.pattern.tutor.deepinjvm.load.WaitLoadExample");
			Object instance = testClass.newInstance();
			System.out.printf("ClassLoader is %s.\n", instance.getClass().getClassLoader());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
