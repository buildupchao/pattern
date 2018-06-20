package com.pattern.tutor.syntax.test.iterator.exception;

public class IteratorException extends RuntimeException {

	private static final long serialVersionUID = -3983584729757931328L;

	public IteratorException() {
		super();
	}

	public IteratorException(String message, Throwable cause) {
		super(message, cause);
	}

	public IteratorException(String message) {
		super(message);
	}
}