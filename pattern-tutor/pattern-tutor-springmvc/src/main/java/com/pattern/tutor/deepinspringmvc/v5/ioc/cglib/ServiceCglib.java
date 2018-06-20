package com.pattern.tutor.deepinspringmvc.v5.ioc.cglib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pattern.tutor.deepinspringmvc.v5.ioc.service.MockService;

@Component
public class ServiceCglib {

	@Autowired
	private MockService mockService;
	
	public String hi(String name) {
		return mockService.hi(name);
	}
}
