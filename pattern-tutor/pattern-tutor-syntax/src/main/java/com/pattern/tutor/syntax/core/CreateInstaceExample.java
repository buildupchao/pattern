package com.pattern.tutor.syntax.core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CreateInstaceExample {

	static void newInstanceByClass() {
		try {
			Class<?> cls = Class.forName("com.pattern.tutor.syntax.core.InstanceExample");
			InstanceExample example = (InstanceExample) cls.newInstance();
			prinlnExample(example);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	static void newInstanceByConstructor() {
		try {
			Constructor<InstanceExample> constructor = InstanceExample.class.getConstructor(new Class[0]);
			try {
				InstanceExample example = constructor.newInstance(new Object[0]);
				prinlnExample(example);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	static void newInstanceByClone() {
		InstanceExample example = new InstanceExample();
		prinlnExample(example);
		
		InstanceExample newExample = (InstanceExample) example.clone();
		prinlnExample(newExample);
	}
	
	static void newInstanceBySerialization() {
		String base = System.getProperty("user.dir") + "/src/main/java/";
		try (ObjectOutputStream out = 
					new ObjectOutputStream(new FileOutputStream(base + "com/pattern/tutor/syntax/core/instance.obj"));
			ObjectInputStream input = 
					new ObjectInputStream(new FileInputStream(base + "com/pattern/tutor/syntax/core/instance.obj"))) {
			InstanceExample outExample = new InstanceExample();
			System.out.printf("out instance id = {%s}.\n", outExample);
			out.writeObject(outExample);
			InstanceExample example = (InstanceExample) input.readObject();
			System.out.printf("out instance id = {%s}.\n", example);
			prinlnExample(example);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void newInstance() {
		prinlnExample(new InstanceExample());
	}
	
	static void prinlnExample(InstanceExample example) {
		System.out.printf("example[name={%s}, num={%d}]\n", example.name, example.num);
	}
	
	public static void main(String[] args) {
//		newInstanceByClass();
//		newInstanceByConstructor();
//		newInstanceByClone();
		newInstanceBySerialization();
//		newInstance();
	}
}
