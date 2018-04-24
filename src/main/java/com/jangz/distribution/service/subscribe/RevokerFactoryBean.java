package com.jangz.distribution.service.subscribe;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RevokerFactoryBean<T> implements FactoryBean<T>, InitializingBean {

	private Class<?> targetInterface;
	private int timeout;
	private T serviceObject;
	private String clusterStrategy;
	private String remoteAppKey;
	private String groupName = "default";
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

	@Override
	public T getObject() throws Exception {
		return serviceObject;
	}

	@Override
	public Class<?> getObjectType() {
		return targetInterface;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
