package com.pattern.tutor.deepinspringmvc.v5.aop.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public void save() {
		System.out.println("..Core business..");
	}
}
