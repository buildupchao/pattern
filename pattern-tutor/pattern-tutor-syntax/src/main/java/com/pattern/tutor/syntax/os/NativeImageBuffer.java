package com.pattern.tutor.syntax.os;

import java.nio.ByteBuffer;

class NativeImageBuffer {
	static {
		java.security.AccessController.doPrivileged(new java.security.PrivilegedAction<Void>() {
			@Override
			public Void run() {
				System.out.println("jimage");
				return null;
			}
		});
	}
	
	native static ByteBuffer getNativeMap(String imagePath);
}
