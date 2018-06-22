package com.pattern.tutor.deepinspringmvc.v5.proxy.agent;

import java.lang.reflect.Method;

import com.google.common.base.Joiner;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

@Slf4j
public class CGLIBProxy implements MethodInterceptor {

	private Object target;
	
	public Object of(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		Object proxyObject = enhancer.create();
		return proxyObject;
	}
	
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		log.info(">>>>>>proxy={}, method={}, args={}, methodProxy={}.",
				proxy.getClass().getName(),
				method.getName(),
				Joiner.on(",").join(args),
				methodProxy.getClass().getName());
		
		checkPopedom();
		
		Object proxyObject = method.invoke(target, args);
		return proxyObject;
	}

	private void checkPopedom() {
		log.info(">>>>>>Check privileges.");
	}
}
