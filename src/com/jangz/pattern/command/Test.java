package com.jangz.pattern.command;

import com.jangz.pattern.command.aop.MethodHandler;
import com.jangz.pattern.command.entity.Light;
import com.jangz.pattern.command.entity.IProduct;

public class Test {

	public static void main(String[] args) {
		IProduct product = new Light();
		IProduct productProxy = (IProduct) MethodHandler.getInstance(product);
		
		LightOnCommand command = new LightOnCommand(productProxy);
		command.execute();
		
		command.undo();
	}

}
