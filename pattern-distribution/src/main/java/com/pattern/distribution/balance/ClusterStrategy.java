package com.pattern.distribution.balance;

import java.util.List;

import com.pattern.distribution.service.ProviderService;

public interface ClusterStrategy {
	ProviderService select(List<ProviderService> providerServices);
}
