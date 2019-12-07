package com.pattern.tutor.syntax.action.newfeature.java8.date;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateFetcherExample {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.printf("today is %s\n", today);

		// fetch the last day of this month
		LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
		System.out.printf("the last day of this month is %s\n", lastDayOfMonth);
		
		// fetch the last day of this year
		LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
		System.out.printf("the last day of this year is %s\n", lastDayOfYear);
		
		// fetch the last day of 2019-02
		LocalDate lastDayOfFeb = today.withMonth(2).with(TemporalAdjusters.lastDayOfMonth());
		System.out.printf("the last day of Feb. is %s\n", lastDayOfFeb);
	}
}