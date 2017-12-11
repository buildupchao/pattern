package com.jangz.newfeature.util.factory;

import java.util.Arrays;
import java.util.List;

import com.jangz.newfeature.entity.Trader;
import com.jangz.newfeature.entity.Transaction;

public class TransactionFactory {
	
	public static List<Transaction> generateTransactionList() {
	    Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		return Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
	}
}
