package com.pattern.distribution.balance;

import com.google.common.base.Objects;

enum ClusterStrategyEnum {
	Random("Random"), WeightRandom("WeightRandom"), Polling("Polling"), WeightPolling("WeightPolling"), Hash("Hash");

	private String name;

	private ClusterStrategyEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static ClusterStrategyEnum queryByCode(String clusterStrategy) {
		ClusterStrategyEnum result = null;
		for (ClusterStrategyEnum e : ClusterStrategyEnum.values()) {
			if (Objects.equal(e.getName(), clusterStrategy)) {
				result = e;
				break;
			}
		}
		return result;
	}

}
