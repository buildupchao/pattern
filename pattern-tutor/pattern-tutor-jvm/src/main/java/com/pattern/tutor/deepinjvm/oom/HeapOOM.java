package com.pattern.tutor.deepinjvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 * @author jangz
 */
public class HeapOOM {
	
	static class OOMObject {
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		
		while (true) {
			list.add(new OOMObject());
		}
	}
}
