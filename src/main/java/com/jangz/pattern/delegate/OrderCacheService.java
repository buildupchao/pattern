package com.jangz.pattern.delegate;

import java.util.List;

public interface OrderCacheService {
	
	List<Integer> getOrderNos();
	
	void refreshCache();
}
