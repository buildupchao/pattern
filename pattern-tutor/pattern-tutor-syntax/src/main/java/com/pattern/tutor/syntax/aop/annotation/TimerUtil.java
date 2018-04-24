package com.pattern.tutor.syntax.aop.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.reflect.MethodUtils;

import com.google.common.collect.Lists;
import com.pattern.tutor.syntax.aop.annotation.meta.Timer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimerUtil {

	public HashMap<String, Long> getTime() {
		HashMap<String, Long> methodsTable = new HashMap<>();
		try {
			String className = Thread.currentThread().getStackTrace()[2].getClassName();
			log.info("current className(expected): {}", className);
			Class<?> cls = Class.forName(className);
			Object obj = cls.newInstance();
			Method[] methods = cls.getDeclaredMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(Timer.class)) {
					method.setAccessible(true);
					long start = System.currentTimeMillis();
					MethodUtils.invokeMethod(obj, method.getName(), new Object[]{});
					long end = System.currentTimeMillis();
					long cost = (end - start);
					log.info(method.getName() + "() time consumed: {} seconds.", (end - start));
					methodsTable.put(method.getName(), cost);
				}
			}
		} catch (IllegalAccessException 
				| IllegalArgumentException 
				| InvocationTargetException
				| NoSuchMethodException 
				| ClassNotFoundException
				| InstantiationException e) {
			e.printStackTrace();
		}
		return methodsTable;
	}

	public HashMap<String, Long> getMethodsTable() {
		HashMap<String, Long> methodsTable = getTime();
		return methodsTable;
	}

	public void printChart() {
		Map<String, Long> result = sortByValue(getMethodsTable());
		double max = result.values().iterator().next();
		for (Map.Entry<String, Long> e : result.entrySet()) {
			double index = e.getValue() / max * 100;
			for (int i = 0; i < index; i++) {
				System.out.println("=");
			}
			System.out.println(e.getKey() + "()" + " Index:" + (long) index + " Time:" + e.getValue());
		}
	}

	<K, V extends Comparable<? super V>> Map<K, V> sortByValue(HashMap<K, V> map) {
		return Lists.newLinkedList(map.entrySet()).stream().sorted((o1, o2) -> o2.getValue().compareTo(o2.getValue()))
				.collect(HashMap::new, (m, v) -> m.put(v.getKey(), v.getValue()), HashMap::putAll);
	}
}
