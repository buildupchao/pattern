package com.pattern.tutor.deepinjvm.load;

public class LoaderExample {
	
	static {
		System.out.printf("%s initialize.\n", LoaderExample.class.getSimpleName());
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	/*	ClassLoader classLoader = LoaderExample.class.getClassLoader();
		System.out.printf("classLoader=%s.\n", classLoader);
		Class<?> cls = classLoader.loadClass("com.pattern.tutor.deepinjvm.load.WaitLoadExample");
		System.out.printf("load class.\n");
		WaitLoadExample example = (WaitLoadExample) cls.newInstance();
		System.out.println("Load class done by ClassLoader#loadClass");*/
		
		/*Class<?> clazz = Class.forName("com.pattern.tutor.deepinjvm.load.WaitLoadExample");
		System.out.println("done load class by Class.forName.");
		clazz.newInstance();*/
		
		ClassLoader classLoader = LoaderExample.class.getClassLoader();
		Class.forName("com.pattern.tutor.deepinjvm.load.WaitLoadExample", true, classLoader);
	}
}
