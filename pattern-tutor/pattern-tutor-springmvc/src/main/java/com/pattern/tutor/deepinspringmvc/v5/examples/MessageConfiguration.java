package com.pattern.tutor.deepinspringmvc.v5.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {

	@Bean
	MessageService mockMessageService() {
		return () -> "hello world!";
	}
}
