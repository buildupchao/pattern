package com.pattern.designpattern.proxy.beans;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HappinessLaundry implements Laundry {

	@Override
	public void wash() {
		log.info("Let HappinessLaundry wash a piece of clothes.");
	}

	@Override
	public void dryCleaning() {
		log.info("Let HappinessLaundry dry clean a piece of clothes.");
	}

}
