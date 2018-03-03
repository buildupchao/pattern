package com.jangz.distribution.balance;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.jangz.distribution.registry.ProviderService;

public class PollingClusterStrategyImpl implements ClusterStrategy {

	private int index;
	private Lock lock = new ReentrantLock();
	
	@Override
	public ProviderService select(List<ProviderService> providerServices) {
		ProviderService service = null;
		try {
			lock.tryLock(10, TimeUnit.MILLISECONDS);
			
			if (index >= providerServices.size())
				index = 0;
			service = providerServices.get(index);
			index++;
			
			if (Objects.isNull(service))
				service = providerServices.get(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return service;
	}

}
