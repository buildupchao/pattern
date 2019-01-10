package com.pattern.tutor.deepinspringmvc.transaction;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Aspect
@Component
public class AopTransaction {

	@Autowired
	private TransactionUtils transactionUtils;
	
	@AfterThrowing("execution(* com.pattern.tutor.deepinspringmvc.*)")
	public void afterThrowing() {
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	}
	
	@Around("execution(* com.pattern.tutor.deepinspringmvc.*)")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		TransactionStatus status = transactionUtils.begin();
		proceedingJoinPoint.proceed();
		transactionUtils.commit(status);
	}
}
