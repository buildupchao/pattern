package com.pattern.designpattern.eventbus.dead;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

import lombok.Data;

@Data
public class DeadEventListener {
	
	boolean notDelivered = false;
	
	@Subscribe
	public void listen(DeadEvent deadEvent) {
		notDelivered = true;
	}
}
