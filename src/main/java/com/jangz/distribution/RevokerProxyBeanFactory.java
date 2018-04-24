package com.jangz.distribution;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;

public class RevokerProxyBeanFactory implements InvocationHandler {

	private ExecutorService executors = null;
	private Class<?> targetInterface;
	private int consumeTimeout;
	private static int threadWorkerNumber = 10;
	private String clusterStrategy;
	
	public RevokerProxyBeanFactory(Class<?> targetInterface, int consumeTimeout, String clusterStrategy) {
		super();
		this.targetInterface = targetInterface;
		this.consumeTimeout = consumeTimeout;
		this.clusterStrategy = clusterStrategy;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		return null;
	}

}
