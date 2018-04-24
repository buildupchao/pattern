package com.jangz.annotation.aop.annotation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import com.jangz.annotation.aop.annotation.meta.Timer;

public class Foo {

	@Timer
	void algo1() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10_000_000; i++) {
			list.add(i);
		}
	}

	@Timer
	void algo2() {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < 10_000_000; i++) {
			list.add(i);
		}
	}

	@Timer
	void algo3() {
		Vector<Integer> vector = new Vector<>();
		for (int i = 0; i < 10_000_000; i++) {
			vector.add(i);
		}
	}
	
	public static void main(String[] args) {
		TimerUtil utils = new TimerUtil();
		utils.printChart();
	}
}
