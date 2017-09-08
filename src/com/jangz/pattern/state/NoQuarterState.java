package com.jangz.pattern.state;

import java.util.logging.Logger;

public class NoQuarterState implements State {
	
	private static final Logger log = Logger.getLogger("NoQuarterState");
	
	GumballMachine gumballMachine;

	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		log.info("You inserted a quarter");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		log.info("You haven't inserted a quarter");
	}

	@Override
	public void turnCrank() {
		log.info("You turned, but there's no quarter");
	}

	@Override
	public void dispense() {
		log.info("You need to pay first");
	}

}
