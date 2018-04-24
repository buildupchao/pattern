package com.pattern.tutor.syntax.action.newfeature.java8.chap6;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;

import com.pattern.tutor.syntax.action.newfeature.java8.entity.Transaction;
import com.pattern.tutor.syntax.action.newfeature.java8.util.factory.TransactionFactory;

public class SimpleUsingStreamExample {

	public static void main(String[] args) {
		Map<Integer, List<Transaction>> transactionsByCurrencies = TransactionFactory.generateTransactionList().stream()
				.collect(groupingBy(Transaction::getValue));
	}
}
