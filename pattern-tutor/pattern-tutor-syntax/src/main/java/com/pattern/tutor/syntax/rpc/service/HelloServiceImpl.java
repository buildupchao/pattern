package com.pattern.tutor.syntax.rpc.service;

public class HelloServiceImpl implements HelloService {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name + "!");
	}

}
