package com.pattern.codingthinking.algothinking.rabbit;

class Rabbit {
	public int born(int n) {
		return (n == 0 || n == 1 || n == 2) ? 1 : born(n - 1) + born(n - 2); 
	}
}

public class CountRabbit {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(new Rabbit().born(i));
		}
	}
}