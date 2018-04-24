package com.jangz.distribution.balance;

import java.util.List;

import com.jangz.distribution.service.ProviderService;

interface ClusterStrategy {
	ProviderService select(List<ProviderService> providerServices);
}
