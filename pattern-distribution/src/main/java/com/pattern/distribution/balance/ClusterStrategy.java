package com.pattern.distribution.balance;

import java.util.List;

import com.pattern.distribution.service.ProviderService;

interface ClusterStrategy {
	ProviderService select(List<ProviderService> providerServices);
}
