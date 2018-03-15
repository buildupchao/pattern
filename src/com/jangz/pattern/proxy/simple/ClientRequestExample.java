package com.jangz.pattern.proxy.simple;

import com.jangz.pattern.proxy.beans.HappinessLaundry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientRequestExample {

	public static void main(String[] args) {
		LaundryProxy proxy = new LaundryProxy(new HappinessLaundry());
		proxy.wash();
		try {
			log.info("Laundry is closing...");
			Thread.sleep(3000);
			log.info("Laundry is opening!!!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		proxy.dryCleaning();
	}
}
