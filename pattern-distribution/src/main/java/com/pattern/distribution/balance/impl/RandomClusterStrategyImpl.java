package com.pattern.distribution.balance.impl;

import java.util.List;

import com.pattern.distribution.balance.ClusterStrategy;
import org.apache.commons.lang3.RandomUtils;

import com.pattern.distribution.service.ProviderService;

public class RandomClusterStrategyImpl implements ClusterStrategy {

	@Override
	public ProviderService select(List<ProviderService> providerServices) {
		int MAX_LEN = providerServices.size();
		int index = RandomUtils.nextInt(0, MAX_LEN - 1);
		return providerServices.get(index);
	}

}
