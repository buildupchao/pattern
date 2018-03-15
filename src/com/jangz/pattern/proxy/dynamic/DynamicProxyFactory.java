package com.jangz.pattern.proxy.dynamic;

import java.lang.reflect.Proxy;

public class DynamicProxyFactory<T> {

	@SuppressWarnings("unchecked")
	public T getProxyInstance(T target) {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
			return method.invoke(target, args);
		});
	}
}
