package com.pattern.designpattern.eventbus.simple;

import com.google.common.eventbus.EventBus;

public class EventBusMain {

	public static void main(String[] args) {
		EventBus eventBus = new EventBus("validator-bus");
		ValidationEventListener validationEventListener = new ValidationEventListener();
		eventBus.register(validationEventListener);
		
		eventBus.post(new ValidationEvent(new DefaultValidator()));
		eventBus.post(new ValidationEvent(new DefaultValidator()));
		eventBus.post(new ValidationEvent(new DefaultValidator()));
	}
}
