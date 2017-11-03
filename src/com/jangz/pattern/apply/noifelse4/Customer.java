package com.jangz.pattern.apply.noifelse4;

public class Customer {
	
	public void consume() throws MovieException {
		Movie regularMovie = new Movie();
		regularMovie.setPrice(Movie.REGULAR);
		
		System.out.println(regularMovie.getPrice().getCharge(10));
		System.out.println(regularMovie.getPrice().getIntegral(10));
	}
}
