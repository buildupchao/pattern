package com.pattern.distribution.net.nio;

import java.nio.CharBuffer;

import com.pattern.common.utils.PrintlnUtils;

public class NIOBufferExample {

	CharBuffer buffer;

	public NIOBufferExample() {
		super();
		buffer = CharBuffer.allocate(80);
	}

	public String readContent() {
		return "NL order will be put into Sales Order Portal.";
	}

	public void tryNio() {
		buffer.append(readContent());
		buffer.flip();
		println();
		
		buffer.rewind();
		println();
		
		buffer.clear();
		buffer.put("U ").put("are ").put("so smart").put("!");
		buffer.flip();
		println();
	}
	
	public void println() {
		StringBuilder cache = new StringBuilder();
		while (buffer.hasRemaining())
			cache.append(buffer.get());
		PrintlnUtils.println(cache.toString());
	}
	
	public static void main(String[] args) {
		new NIOBufferExample().tryNio();
	}
}
