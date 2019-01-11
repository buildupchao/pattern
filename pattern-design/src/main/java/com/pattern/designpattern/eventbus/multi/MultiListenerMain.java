package com.pattern.designpattern.eventbus.multi;

import com.google.common.eventbus.EventBus;

public class MultiListenerMain {

	public static void main(String[] args) {
		EventBus eventBus = new EventBus("number-bus");
		eventBus.register(new MultiListener());
		
		eventBus.post(new Integer(1));
		eventBus.post(new Integer(2));
		eventBus.post(new Integer(3));
		
		eventBus.post(new Long(31));
		eventBus.post(new Long(32));
		eventBus.post(new Long(33));
	}
}
