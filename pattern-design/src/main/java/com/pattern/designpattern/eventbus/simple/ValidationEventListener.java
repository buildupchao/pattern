package com.pattern.designpattern.eventbus.simple;

import com.google.common.eventbus.Subscribe;

public class ValidationEventListener {
	
	private boolean validationResult = false;
	
	@Subscribe
	public void listen(ValidationEvent validationEvent) {
		validationResult = validationEvent.getValidator().validate();

		System.out.printf("Get event: %s, %s\n", validationEvent, validationResult);
	}

	public boolean isValidationResult() {
		return validationResult;
	}
}
