package com.pattern.designpattern.eventbus.multi;

import com.google.common.eventbus.Subscribe;

import lombok.Data;

@Data
public class MultiListener {
	
	private Integer lastInteger;
	private Long lastLong;
	
	@Subscribe
	public void listenInteger(Integer event) {
		lastInteger = event;
		
		System.out.printf("Get integer event: %d\n", event);
	}
	
	@Subscribe
	public void listenLong(Long event) {
		lastLong = event;
		
		System.out.printf("Get long event: %d\n", event);
	}
}
