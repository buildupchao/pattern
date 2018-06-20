package com.pattern.distribution.balance;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.pattern.distribution.BaseTest;
import com.pattern.distribution.service.ProviderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClusterEngineTest extends BaseTest {

	@Test
	public void testSelectClusterStrategy() throws Exception {
		ProviderService service = ClusterEngine.selectClusterStrategy(ClusterStrategyEnum.Polling).select(providerServices());
		log.info("Selected ProviderService is {}, {}.", service.getWeight(), service.getClass().getSimpleName());
		log.info(">>>Success.");
	}
	
	private List<ProviderService> providerServices() {
		class ZeroWeightService implements ProviderService {
			@Override
			public int getWeight() {
				return 0;
			}

			@Override
			public ProviderService copy() {
				return this;
			}
		};
		class OneWeightService implements ProviderService {
			
			@Override
			public int getWeight() {
				return 1;
			}
			
			@Override
			public ProviderService copy() {
				return this;
			}
		}
		return Arrays.asList(new ZeroWeightService(), new OneWeightService());
	}
}
