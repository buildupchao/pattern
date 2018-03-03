package com.jangz.distribution.registry;

import java.util.List;
import java.util.Map;

import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import com.google.common.collect.Maps;
import com.jangz.distribution.service.InvokerService;
import com.jangz.distribution.service.ProviderService;
import com.jangz.distribution.utils.PropertyConfigHelper;

public class RegisterCenter implements IRegisterCenter4Provider, IRegisterCenter4Invoker {

	private static RegisterCenter registerCenter = new RegisterCenter();
	private static final Map<String, List<ProviderService>> providerServiceMap = Maps.newHashMap();
	
	private static final Map<String, List<ProviderService>> serviceMetaDataMap4Consume = Maps.newHashMap();
	private static final String ZK_SERVICE = PropertyConfigHelper.getZkService();
	private static final int ZK_SESSION_TIME_OUT = PropertyConfigHelper.getZkConnectionTimeout();
	private static String ROOT_PATH = "/config_register/" + PropertyConfigHelper.getAppName();
	private static String PROVIDER_TYPE = "/provider";
	private static String INVOKER_TYPE = "/consumer";
	private static volatile ZkClient zkClient = null;
	
	private RegisterCenter() {}
	
	public static RegisterCenter singleton() {
		return registerCenter;
	}
	
	@Override
	public void initProviderMap() {
		if (MapUtils.isEmpty(serviceMetaDataMap4Consume))
			serviceMetaDataMap4Consume.putAll(fetchOrUpdateServiceMetaData());
	}

	private Map<? extends String, ? extends List<ProviderService>> fetchOrUpdateServiceMetaData() {
		return null;
	}

	@Override
	public Map<String, List<ProviderService>> getServiceMetaDataMap4Consume() {
		return serviceMetaDataMap4Consume;
	}

	@Override
	public void registerInvoker(InvokerService invoker) {

	}

	@Override
	public void registerProvider(List<ProviderService> serviceMetaData) {
		if (CollectionUtils.isEmpty(serviceMetaData))
			return;
		
		synchronized (RegisterCenter.class) {
			for (ProviderService provider : serviceMetaData) {
				
			}
		}
	}

	@Override
	public Map<String, List<ProviderService>> getProviderServiceMap() {
		return providerServiceMap;
	}

}
