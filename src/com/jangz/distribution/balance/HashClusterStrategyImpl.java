package com.jangz.distribution.balance;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import com.jangz.distribution.registry.ProviderService;

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
