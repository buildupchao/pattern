package com.pattern.designpattern.proxy.dynamic;

import java.lang.reflect.Proxy;

import com.pattern.designpattern.proxy.beans.HappinessLaundry;
import com.pattern.designpattern.proxy.beans.Laundry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientRequestDynamicHandler {
	
	public static void main(String[] args) {
		Laundry laundry = new HappinessLaundry();
		LaundryDynamicProxy proxy = new LaundryDynamicProxy(laundry);
		ClassLoader classLoader = laundry.getClass().getClassLoader();
		Laundry proxyObject = (Laundry) Proxy.newProxyInstance(classLoader, new Class[]{Laundry.class}, proxy);
		proxyObject.wash();
		try {
			log.info("Laundry is closing...");
			Thread.sleep(3000);
			log.info("Laundry is opening!!!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		proxyObject.dryCleaning();
	}
}
