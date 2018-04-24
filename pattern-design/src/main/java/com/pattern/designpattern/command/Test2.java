package com.pattern.designpattern.command;

import com.pattern.designpattern.command.aop.CglibProxy;
import com.pattern.designpattern.command.entity.IProduct;
import com.pattern.designpattern.command.entity.Light;

public class Test2 {

	public static void main(String[] args) {
		IProduct light = (IProduct) CglibProxy.getInstace(Light.class);

		Command command = new LightOnCommand(light);
		command.execute();
		command.undo();
	}

}
