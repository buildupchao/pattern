package com.pattern.designpattern.state;

import java.util.logging.Logger;

public class GumballMachineTestDrive {
	
	private static final Logger log = Logger.getLogger("GumballMachineTestDrive");
	
	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);
		log.info("" + gumballMachine);
		
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		
		log.info("" + gumballMachine);
		
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
	}
	
}
