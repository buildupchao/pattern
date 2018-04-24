package com.pattern.designpattern.apply.noifelse4;

public class MovieException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8981986187817689264L;

	public MovieException(String message, Throwable cause) {
		super(message, cause);
	}

	public MovieException(String message) {
		super(message);
	}

}
