package com.pattern.tutor.syntax.collection.custom.basic;

import java.io.Serializable;

public final class ZString implements Serializable, Comparable<ZString>, CharSequence {

	private static final long serialVersionUID = -104198781891118592L;

	private final char[] value;
	
	private int hash;
	
	public ZString() {
		this.value = "".toCharArray();
	}
	
	@Override
	public int length() {
		return value.length;
	}

	@Override
	public char charAt(int index) {
		return 0;
	}
	
/*	public byte[] getBytes() {
		return StringCoding
	}*/

	@Override
	public CharSequence subSequence(int start, int end) {
		return null;
	}

	@Override
	public int compareTo(ZString o) {
		return 0;
	}

}
