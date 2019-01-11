package com.pattern.designpattern.eventbus.simple;

import java.util.Random;

public class DefaultValidator implements Validator {

	@Override
	public boolean validate() {
		return new Random().nextBoolean();
	}

}
