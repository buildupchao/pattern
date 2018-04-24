package com.pattern.designpattern.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CharacterInputStream extends FilterInputStream {

	private static final int NULL = 0;
	
	protected CharacterInputStream(InputStream in) {
		super(in);
	}
	
	@Override
	public int read() throws IOException {
		int c = super.read();
		
		return c == -1 ? c : convert((char) c);
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int result = super.read(b, off, len);
		
		for (int i = off; i < off + result; i++) {
			b[i] = (byte) convert((char) b[i]);
		}
		return result;
	}
	
	private int convert(char c) {
		if (isUpperCase(c)) {
			return Character.toLowerCase(c);
		} else if (isLowerCase(c)) {
			return Character.toUpperCase(c);
		}
		return NULL;
	}
	
	private boolean isUpperCase(char c) {
		return c >= 'A' && c <= 'Z';
	}
	
	private boolean isLowerCase(char c) {
		return c >= 'a' && c <= 'z';
	}
}
