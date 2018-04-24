package com.jangz.structure.basic;

import java.lang.ref.SoftReference;

/**
 * Utility class for string encoding and decoding
 */
public class ZStringCoding {

	private ZStringCoding() {
	}

	/* The cached coders for each thread */
	private final static ThreadLocal<SoftReference<StringDecoder>> decoder = new ThreadLocal<>();
	private final static ThreadLocal<SoftReference<StringEncoder>> coder = new ThreadLocal<>();

	private static class StringDecoder {

	}

	private static class StringEncoder {

	}
}
