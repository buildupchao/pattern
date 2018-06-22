package com.pattern.tutor.deepinspringmvc.v5.proxy.service;

public class AccountServiceImpl implements AccountService {

	@Override
	public void insert(String username, String password) {
		System.out.printf(">>>>>>Call %s#insert(%s, %s).\n", this.getClass().getSimpleName(), username, password);
	}

	@Override
	public void delete(String username) {
		System.out.printf(">>>>>>Call %s#delete(%s).\n", this.getClass().getSimpleName(), username);
	}

}
