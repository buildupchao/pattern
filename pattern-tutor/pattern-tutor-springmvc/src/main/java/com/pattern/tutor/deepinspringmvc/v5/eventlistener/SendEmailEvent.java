package com.pattern.tutor.deepinspringmvc.v5.eventlistener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class SendEmailEvent extends ApplicationContextEvent {

	private static final long serialVersionUID = -4140838898076251419L;

	private String toEmail;
	
	public SendEmailEvent(ApplicationContext source, String toEmail) {
		super(source);
		this.toEmail = toEmail;
	}

	public String getToEmail() {
		return toEmail;
	}
}
