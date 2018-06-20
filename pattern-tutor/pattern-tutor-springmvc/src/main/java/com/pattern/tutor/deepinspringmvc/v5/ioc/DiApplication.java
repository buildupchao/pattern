package com.pattern.tutor.deepinspringmvc.v5.ioc;

import java.util.Objects;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pattern.tutor.deepinspringmvc.v5.ioc.cglib.CglibPackage;
import com.pattern.tutor.deepinspringmvc.v5.ioc.cglib.ServiceCglib;
import com.pattern.tutor.deepinspringmvc.v5.ioc.service.MockService;
import com.pattern.tutor.deepinspringmvc.v5.ioc.service.ServicePackage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DiApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ServicePackage.class, CglibPackage.class);
		MockService mockService = (MockService) ctx.getBean("mockService");
		Objects.requireNonNull(mockService, "MockService initializing success.");
		
		ServiceCglib serviceCglib = (ServiceCglib) ctx.getBean("serviceCglib");
		Objects.requireNonNull(serviceCglib, "ServiceCglib initializing success.");
		
		log.info("Message from mockService is {}", mockService.hi("jangz"));
		log.info("Message from serviceCglib is {}", serviceCglib.hi("jangz"));
		
		ctx.close();
	}
}
