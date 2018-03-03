package com.jangz.distribution.registry;

import java.util.List;
import java.util.Map;

import com.jangz.distribution.service.InvokerService;
import com.jangz.distribution.service.ProviderService;

public interface IRegisterCenter4Invoker {
	
	void initProviderMap();
	
	Map<String, List<ProviderService>> getServiceMetaDataMap4Consume();
	
	void registerInvoker(final InvokerService invoker);
}
