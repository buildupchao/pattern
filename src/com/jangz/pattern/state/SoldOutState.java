package com.jangz.pattern.state;

import java.util.logging.Logger;

public class SoldOutState implements State {

	private static final Logger log = Logger.getLogger("SoldOutState");
	
	GumballMachine gumballMachine;

	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		log.info("Cannot insert a quarter. It is an error!");
	}

	@Override
	public void ejectQuarter() {
		log.info("Cannot eject a quarter. It is an error!");
	}

	@Override
	public void turnCrank() {
		log.info("Cannot turn the crank. It is an error!");
	}

	@Override
	public void dispense() {
		log.info("Cannot dispense. It sold out.");
	}

}
