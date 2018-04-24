package com.jangz.pattern.command.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;

import com.jangz.pattern.command.stereotype.MethodReport;

public class MethodHandler implements InvocationHandler {

	private static final Logger log = Logger.getLogger("MethodHandler");

	private Object target;

	public static Object getInstance(Object o) {
		MethodHandler proxy = new MethodHandler();
		proxy.target = o;
		
		Object result = Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), proxy);
		return result;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.isAnnotationPresent(MethodReport.class)) {
			log.info(method.getName() + "...");
		}
		Object o = method.invoke(target, args);
		return o;
	}

}
