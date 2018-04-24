package com.jangz.pattern.command.aop;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import com.jangz.pattern.command.stereotype.MethodReport;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private static final Logger log = Logger.getLogger("CglibProxy");
	
	@Override
	public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		if (method.isAnnotationPresent(MethodReport.class)) {
			log.info(method.getName() + "...");
		}
		Object o1 = methodProxy.invokeSuper(o, args);
		return o1;
	}
	
	public static Object getInstace(Class<?> clazz) {
		CglibProxy cglibProxy = new CglibProxy();
		Enhancer enhancer = new Enhancer();
		
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(cglibProxy);
		
		return enhancer.create();
	}

}
