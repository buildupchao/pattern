package com.jangz.pattern.state;

import java.util.Random;
import java.util.logging.Logger;

public class HasQuarterState implements State {
	
	private static final Logger log = Logger.getLogger("HasQuarterState");
	
	Random randomWinner = new Random(System.currentTimeMillis());
	GumballMachine gumballMachine;

	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		log.info("You can't insert another quarter");
	}

	@Override
	public void ejectQuarter() {
		log.info("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		log.info("You turned...");
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	@Override
	public void dispense() {
		log.info("No gumball dispensed");
	}

}
