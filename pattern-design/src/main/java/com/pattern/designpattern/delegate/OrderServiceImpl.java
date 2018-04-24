package com.pattern.designpattern.delegate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class OrderServiceImpl implements OrderService {

	@Override
	public List<Integer> getOpenOrderNos() {
		return getOrderNos().stream().filter(orderNo -> orderNo % 2 == 0).collect(Collectors.toList());
	}
	
	List<Integer> getOrderNos() {
		return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
	}
}
