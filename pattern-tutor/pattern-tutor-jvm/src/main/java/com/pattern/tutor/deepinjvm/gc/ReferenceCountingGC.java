package com.pattern.tutor.deepinjvm.gc;

public class ReferenceCountingGC {

	public Object instance = null;
	
	private static final int oneMB = 1024 * 1024;
	
	private byte[] bigSize = new byte[2 * oneMB];
	
	public static void testGC() {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		System.gc();
	}
}
