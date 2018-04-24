package com.jangz.distribution.balance;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;

import com.jangz.distribution.service.ProviderService;

class RandomClusterStrategyImpl implements ClusterStrategy {

	@Override
	public ProviderService select(List<ProviderService> providerServices) {
		int MAX_LEN = providerServices.size();
		int index = RandomUtils.nextInt(0, MAX_LEN - 1);
		return providerServices.get(index);
	}

}
