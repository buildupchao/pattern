package com.jangz.annotation.aop.callback;

public class TimerUtil {
	
	public void getTime(Callback callback) {
		long start = System.currentTimeMillis();
		callback.execute();
		long end = System.currentTimeMillis();
		System.out.println(callback.getClass().getSimpleName() + "->" + ((end - start) / 1000.0) + "S.");
	}
}
