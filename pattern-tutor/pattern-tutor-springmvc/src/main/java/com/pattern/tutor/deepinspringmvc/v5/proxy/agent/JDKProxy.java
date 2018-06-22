package com.pattern.tutor.deepinspringmvc.v5.proxy.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.google.common.base.Joiner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JDKProxy implements InvocationHandler {

	private Object target;

	public Object newProxy(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		log.info(">>>>>>proxy={}, method={}, args={}.", 
				proxy.getClass().getName(),
				method.getName(),
				Joiner.on(",").join(args));
		
		checkPopedom();
		Object proxyObject = null;
		proxyObject = method.invoke(target, args);
		return proxyObject;
	}

	private void checkPopedom() {
		log.info(">>>>>>Check privileges.");
	}
}
