package com.pattern.tutor.syntax.test.unsafe;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;

import lombok.Data;

public class UnSafeOperation {
	
	public static void main(String[] args) {
		immutableString();
		unsafeCollection();
	}
	
	public static void immutableString() {
		DataHolder<String> holder = new DataHolder<>();
		String hold = "hold";
		holder.setHold(hold);
		hold = "changed";
		System.out.println(holder.getHold());
	}
	
	public static void unsafeCollection() {
		DataHolder<List<String>> holder = new DataHolder<>();
		List<String> list = Arrays.asList("A", "B", "C");
		holder.setHold(list);
		list.set(1, "BB");
		System.out.println(Joiner.on(",").join(list));
	}
	
	@Data
	static class DataHolder<T> {
		private T hold;
	}
}
