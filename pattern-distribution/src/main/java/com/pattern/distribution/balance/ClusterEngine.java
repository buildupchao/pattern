package com.pattern.distribution.balance;

import java.util.Map;

import com.google.common.collect.Maps;

public class ClusterEngine {
	
	private static final ClusterStrategy DEFAULT = new RandomClusterStrategyImpl();
	private static final Map<ClusterStrategyEnum, ClusterStrategy> clusterStrategyMap = Maps.newHashMap();
	
	static {
		clusterStrategyMap.put(ClusterStrategyEnum.Random, new RandomClusterStrategyImpl());
		clusterStrategyMap.put(ClusterStrategyEnum.WeightRandom, new WeightRandomClusterStrategyImpl());
		clusterStrategyMap.put(ClusterStrategyEnum.Polling, new PollingClusterStrategyImpl());
		clusterStrategyMap.put(ClusterStrategyEnum.WeightPolling, new WeightPollingClusterStrategyImpl());
		clusterStrategyMap.put(ClusterStrategyEnum.Hash, new HashClusterStrategyImpl());
	}
	
	public static ClusterStrategy selectClusterStrategy(ClusterStrategyEnum clusterStrategy) {
		return clusterStrategyMap.getOrDefault(clusterStrategy, DEFAULT);
	}
}
