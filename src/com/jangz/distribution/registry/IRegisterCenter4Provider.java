package com.jangz.distribution.registry;

import java.util.List;
import java.util.Map;

import com.jangz.distribution.service.ProviderService;

public interface IRegisterCenter4Provider {

	void registerProvider(final List<ProviderService> serviceMetaData);
	
	Map<String, List<ProviderService>> getProviderServiceMap();
}
