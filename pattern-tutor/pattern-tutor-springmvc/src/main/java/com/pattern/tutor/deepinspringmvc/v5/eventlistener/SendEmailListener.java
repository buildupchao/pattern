package com.pattern.tutor.deepinspringmvc.v5.eventlistener;

import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SendEmailListener implements ApplicationListener<SendEmailEvent> {

	@Override
	public void onApplicationEvent(SendEmailEvent event) {
		System.out.println("Send email to " + Optional.ofNullable(event.getToEmail()).orElse("Unknown"));
	}
}
