package com.jangz.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Format {
	
	public static void main(String[] args) {
		String dateStr = "08/29/2017 00:10 PM";
		System.out.println(dateStr.length());
		Date date = new Date(dateStr);
		System.out.println(date.getHours());
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm aa", Locale.ENGLISH);
		String dateStr2 = format.format(date);
		
		System.out.println(dateStr2);
	}
	
}
