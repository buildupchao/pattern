package com.pattern.designpattern.eventbus.simple;

import lombok.Data;

@Data
public class ValidationEvent {
	
	private Validator validator;

	public ValidationEvent(Validator validator) {
		super();
		this.validator = validator;
	}
}
