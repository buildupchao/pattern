package com.jangz.pattern.state;

import java.util.logging.Logger;

public class WinnerState implements State {

	private static final Logger log = Logger.getLogger("WinnerState");

	GumballMachine gumballMachine;

	public WinnerState(GumballMachine gumballMachine) {
		super();
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
		log.info("You're a winner! You get two gumballs for your quarter");
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.getSoldOutState());
		} else {
			gumballMachine.releaseBall();
			if (gumballMachine.getCount() > 0) {
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			} else {
				log.info("Oops, out of gumballs!");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
	}

}
