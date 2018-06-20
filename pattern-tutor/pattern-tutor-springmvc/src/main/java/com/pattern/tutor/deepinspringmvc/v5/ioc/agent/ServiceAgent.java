package com.pattern.tutor.deepinspringmvc.v5.ioc.agent;

import com.pattern.tutor.deepinspringmvc.v5.ioc.service.MockService;

import lombok.Data;

@Data
public class ServiceAgent {

	private MockService mockService;

	public String hi(String name) {
		return mockService.hi(name);
	}
}
