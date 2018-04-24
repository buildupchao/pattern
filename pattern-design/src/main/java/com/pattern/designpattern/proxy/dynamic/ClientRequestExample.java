package com.pattern.designpattern.proxy.dynamic;

import com.pattern.designpattern.proxy.beans.HappinessLaundry;
import com.pattern.designpattern.proxy.beans.Laundry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientRequestExample {

	public static void main(String[] args) {
		Laundry proxyInstance = new DynamicProxyFactory<Laundry>().getProxyInstance(new HappinessLaundry());
		proxyInstance.wash();
		try {
			log.info("Laundry is closing...");
			Thread.sleep(3000);
			log.info("Laundry is opening!!!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		proxyInstance.dryCleaning();
	}
}
