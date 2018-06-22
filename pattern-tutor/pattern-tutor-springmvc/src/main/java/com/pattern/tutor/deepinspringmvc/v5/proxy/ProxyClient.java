package com.pattern.tutor.deepinspringmvc.v5.proxy;

import com.pattern.tutor.deepinspringmvc.v5.proxy.agent.CGLIBProxy;
import com.pattern.tutor.deepinspringmvc.v5.proxy.agent.JDKProxy;
import com.pattern.tutor.deepinspringmvc.v5.proxy.service.AccountService;
import com.pattern.tutor.deepinspringmvc.v5.proxy.service.AccountServiceImpl;

public class ProxyClient {
	
	public static void main(String[] args) {
		usingJDKProxy();
		
		System.out.println();
		
		usingCGLIBProxy();
	}
	
	private static void usingJDKProxy() {
		AccountService accountService = 
				(AccountService) new JDKProxy().newProxy(new AccountServiceImpl());
		accountService.insert("root", "123456");
		accountService.delete("root");
	}
	
	private static void usingCGLIBProxy() {
		AccountService accountService = 
				(AccountService) new CGLIBProxy().of(new AccountServiceImpl());
		accountService.insert("jangz", "654321");
		accountService.delete("jangz");
	}
}
