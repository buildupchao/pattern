package com.jangz.syntax.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RPCProxyClient implements InvocationHandler {

	private Object object;

	public RPCProxyClient(Object object) {
		this.object = object;
	}

	public Object getProxy(Object obj) {
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
				new RPCProxyClient(obj));
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = new Object();
		
		
		return result;
	}

}
