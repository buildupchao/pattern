package com.pattern.tutor.deepinspringmvc.v5.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

	private final MessageService messageService;

	@Autowired
	public MessagePrinter(MessageService messageService) {
		super();
		this.messageService = messageService;
	}

	public void printMessage() {
		System.out.println(this.messageService.getMessage());
	}
}
