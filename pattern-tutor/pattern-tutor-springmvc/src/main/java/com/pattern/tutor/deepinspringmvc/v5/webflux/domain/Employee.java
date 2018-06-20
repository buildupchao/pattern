package com.pattern.tutor.deepinspringmvc.v5.webflux.domain;

import lombok.Data;

@Data
public class Employee {

	private Long id;
	private String firstName;
	private String lastName;
	private String description;

	private Long version;

	public Employee(String firstName, String lastName, String description) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
	}

	public Employee() {
		super();
	}
}
