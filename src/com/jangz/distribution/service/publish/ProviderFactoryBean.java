package com.jangz.distribution.service.publish;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderFactoryBean<T> implements FactoryBean<T>, InitializingBean {

	private Class<?> serviceInterface;
	private Object serviceObject;
	private String serverPort;
	private long timeout;
	private T serviceProxyObject;
	private String appKey;
	private String groupName = "default";
	private int weight = -1;
	private int workerThreads = 10;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

	@Override
	public T getObject() throws Exception {
		return serviceProxyObject;
	}

	@Override
	public Class<?> getObjectType() {
		return serviceInterface;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
