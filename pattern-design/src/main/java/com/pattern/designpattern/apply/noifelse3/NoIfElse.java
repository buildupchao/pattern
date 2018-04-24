package com.pattern.designpattern.apply.noifelse3;

public class NoIfElse {
	public static void main(String[] args) {
		int i = 8;
		
		Pattern.with(i).matcher(x -> {
			if (x % 2 != 0) {
				System.out.println("odd");
				return true;
			}
			return false;
		}).matcher(x -> {
			if (x % 2 == 0) {
				System.out.println("even");
				return true;
			}
			return false;
		}).match();
		
		Cat cat = new Cat("苗苗", 2);
		Pattern.with(cat).matcher(x -> x.getAge() < 3).match();
	}
}
