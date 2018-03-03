package com.jangz.distribution.balance;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;

import com.google.common.collect.Lists;
import com.jangz.distribution.service.ProviderService;

class WeightRandomClusterStrategyImpl implements ClusterStrategy {

	@Override
	public ProviderService select(List<ProviderService> providerServices) {
		List<ProviderService> providers = Lists.newArrayList();
		for (ProviderService provider : providerServices) {
			int weight = provider.getWeight();
			for (int i = 0; i < weight; i++)
				providers.add(provider.copy());
		}
		
		int MAX_LEN = providers.size();
		int index = RandomUtils.nextInt(0, MAX_LEN - 1);
		return providers.get(index);
	}

}
