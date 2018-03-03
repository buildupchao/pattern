package com.jangz.distribution.balance;

import java.util.List;

import com.jangz.distribution.registry.ProviderService;

public interface ClusterStrategy {
	ProviderService select(List<ProviderService> providerServices);
}
