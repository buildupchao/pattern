package com.pattern.designpattern.delegate;

import java.util.List;

public interface OrderCacheService {
	
	List<Integer> getOrderNos();
	
	void refreshCache();
}
