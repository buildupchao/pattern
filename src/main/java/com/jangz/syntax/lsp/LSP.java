package com.jangz.syntax.lsp;

import java.util.ArrayList;
import java.util.List;

public class LSP {
	
	public static void main(String[] args) {
		Number num = new Integer(1);
//		ArrayList<Number> list = new ArrayList<Integer>();
		
		/*List<? extends Number> list2 = new ArrayList<Number>();
		list2.add(new Integer(1));
		list2.add(new Float(2f));*/
		
	}
	
	public void realizeInRegex() {
		List<? extends Number> list = new ArrayList<Integer>(); // 协变——>上限
		
		List<? super Number> list2 = new ArrayList<Object>(); // 逆变——>下限
		list2.add(new Integer(1));
		list2.add(new Float(2f));
	}
}
