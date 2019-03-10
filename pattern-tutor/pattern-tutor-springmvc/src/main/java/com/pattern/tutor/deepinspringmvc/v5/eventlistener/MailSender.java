package com.pattern.tutor.deepinspringmvc.v5.eventlistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MailSender {

	@Autowired
	private ApplicationContext context;
	
	public void sendEmail(String toEmail) {
		System.out.println("Send email!");
		SendEmailEvent sendEmailEvent = new SendEmailEvent(context, toEmail);
		context.publishEvent(sendEmailEvent);
	}
}
