package com.pattern.tutor.deepinspringmvc.v5.ioc.service;

import org.springframework.stereotype.Component;

@Component
public class MockService {

	public String hi(String name) {
		return String.format("hi %s.", name);
	}
}
