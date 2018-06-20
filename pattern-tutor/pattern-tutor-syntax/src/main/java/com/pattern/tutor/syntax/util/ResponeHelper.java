package com.pattern.tutor.syntax.util;

public class ResponeHelper {
	
	public static Response createInstance() {
		return new Response();
	}
	
	public static Response of() {
		return createInstance();
	}
}
