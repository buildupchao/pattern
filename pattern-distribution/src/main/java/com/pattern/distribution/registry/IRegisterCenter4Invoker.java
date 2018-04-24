package com.pattern.distribution.registry;

import java.util.List;
import java.util.Map;

import com.pattern.distribution.service.InvokerService;
import com.pattern.distribution.service.ProviderService;

public interface IRegisterCenter4Invoker {
	
	void initProviderMap();
	
	Map<String, List<ProviderService>> getServiceMetaDataMap4Consume();
	
	void registerInvoker(final InvokerService invoker);
}
