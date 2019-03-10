package com.pattern.distribution.balance.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import com.pattern.distribution.balance.ClusterStrategy;
import com.pattern.distribution.service.ProviderService;

public class HashClusterStrategyImpl implements ClusterStrategy {

	@Override
	public ProviderService select(List<ProviderService> providerServices) {
		try {
			String localIP = InetAddress.getLocalHost().getHostAddress();
			int hashCode = localIP.hashCode();
			int size = providerServices.size();
			return providerServices.get(hashCode % size);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}

}
