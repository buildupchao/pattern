package com.pattern.designpattern.delegate;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderCacheServiceImpl extends OrderServiceImpl implements OrderCacheService {

	@Override
	public List<Integer> getOrderNos() {
		return super.getOrderNos();
	}

	@Override
	public void refreshCache() {
		log.info("Refresh cache Done.");
	}

}
