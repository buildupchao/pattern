package com.jangz.newfeature.chap5;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.List;

import com.jangz.newfeature.entity.Trader;
import com.jangz.newfeature.entity.Transaction;
import com.jangz.newfeature.util.factory.TransactionFactory;

public class PuttingIntoPractice {

	public static void main(String[] args) {
		List<Transaction> transactions = TransactionFactory.generateTransactionList();

		sort(transactions);
		System.out.println("-----------------------------------");

		distinctCity(transactions);
		System.out.println("-----------------------------------");

		find(transactions);
		System.out.println("-----------------------------------");

		getNameListAndSortByName(transactions);
		System.out.println("-----------------------------------");

		checkIfExistWorkInMilan(transactions);
		System.out.println("-----------------------------------");
		
		printTrasactionWithWorkingInCambridge(transactions);
		System.out.println("-----------------------------------");

		printHighTransaction(transactions);
		System.out.println("-----------------------------------");
		
		printLowTransaction(transactions);
	}

	public static void sort(List<Transaction> transactions) {
		transactions.stream().filter(transaction -> transaction.getYear() == 2011)
				.sorted(comparing(Transaction::getValue)).forEach(System.out::println);
	}

	public static void distinctCity(List<Transaction> transactions) {
		List<String> cities = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct()
				.collect(toList());
		System.out.println(cities);
	}

	public static void find(List<Transaction> transactions) {
		List<Trader> traders = transactions.stream().map(Transaction::getTrader)
				.filter(trader -> trader.getCity().equals("Cambridge")).sorted(comparing(Trader::getName))
				.collect(toList());
		System.out.println(traders);
	}

	public static void getNameListAndSortByName(List<Transaction> transactions) {
		transactions.stream().map(Transaction::getTrader).map(Trader::getName).sorted().collect(toList())
				.forEach(System.out::println);
	}

	public static void checkIfExistWorkInMilan(List<Transaction> transactions) {
		boolean exist = transactions.stream()
				.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		System.out.println(exist);
	}

	public static void printTrasactionWithWorkingInCambridge(List<Transaction> transactions) {
		transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue).forEach(System.out::println);
	}
	
	public static void printHighTransaction(List<Transaction> transactions) {
		transactions.stream().max(comparing(Transaction::getValue)).ifPresent(System.out::println);
	}
	
	public static void printLowTransaction(List<Transaction> transactions) {
		transactions.stream().min(comparing(Transaction::getValue)).ifPresent(System.out::println);
	}
}
