package com.pattern.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LaundryDynamicProxy implements InvocationHandler {

	private Object o;
	
	public LaundryDynamicProxy(Object o) {
		super();
		this.o = o;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(o, args);
		return result;
	}

}
