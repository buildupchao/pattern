package com.jangz.test.again;

public class RepeatCommit {
	
	public static void main(String[] args) {
		String method = "updateOrderStatus";
		String params = "orderNo=88687909&orderType=1&orderLineNo=1";
		
		System.out.println(new RepeatCommit().generateHashCode(method, params));
		System.out.println(new RepeatCommit().generateHashCode(method, params));
	}
	
	
	public int generateHashCode(String method, String params) {
		return (method + params).hashCode();
	}
}
