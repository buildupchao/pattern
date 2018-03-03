package com.jangz.distribution.balance;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.google.common.collect.Lists;
import com.jangz.distribution.service.ProviderService;

class WeightPollingClusterStrategyImpl implements ClusterStrategy {

	private int index = 0;
	private Lock lock = new ReentrantLock();
	
	@Override
	public ProviderService select(List<ProviderService> providerServices) {
		ProviderService service = null;
		try {
			lock.tryLock(10, TimeUnit.MILLISECONDS);
			List<ProviderService> providers = Lists.newArrayList();
			for (ProviderService provider : providerServices) {
				int weight = provider.getWeight();
				for (int i = 0; i < weight; i++)
					providers.add(provider.copy());
			}
			
			if (index >= providers.size())
				index = 0;
			service = providers.get(index);
			index++;
			
			if (Objects.isNull(service))
				service = providers.get(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return service;
	}

}
