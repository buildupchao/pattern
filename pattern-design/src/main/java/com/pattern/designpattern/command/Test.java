package com.pattern.designpattern.command;

import com.pattern.designpattern.command.aop.MethodHandler;
import com.pattern.designpattern.command.entity.IProduct;
import com.pattern.designpattern.command.entity.Light;

public class Test {

	public static void main(String[] args) {
		IProduct product = new Light();
		IProduct productProxy = (IProduct) MethodHandler.getInstance(product);
		
		LightOnCommand command = new LightOnCommand(productProxy);
		command.execute();
		
		command.undo();
	}

}
