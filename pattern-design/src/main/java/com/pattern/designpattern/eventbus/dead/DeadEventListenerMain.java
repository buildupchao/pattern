package com.pattern.designpattern.eventbus.dead;

import com.google.common.eventbus.EventBus;

public class DeadEventListenerMain {

	public static void main(String[] args) {
		EventBus eventBus = new EventBus("dead-event-bus");
		DeadEventListener listener = new DeadEventListener();
		eventBus.register(listener);
		
		eventBus.post(new Integer(1));
		eventBus.post(new Integer(1));
		eventBus.post(new Integer(1));
		
		System.out.println("Last the notDelivered is : " + listener.isNotDelivered());
	}
}
