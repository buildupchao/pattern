package com.pattern.designpattern.command2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CommandMain {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		CommandOrder phoneCommand = new CommandOrder("phone");
		String value = phoneCommand.execute();
		System.out.println("sync: " + value);
		
		CommandOrder tvCommand = new CommandOrder("tv");
		Future<String> future = tvCommand.queue();
		String info = future.get(200, TimeUnit.MILLISECONDS);
		System.out.println("async: " + info);
		
		CommandUser userCommand = new CommandUser("chaochao");
		String name = userCommand.execute();
		System.out.println(name);
	}
}
