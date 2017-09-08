package com.jangz.pattern.command;

import com.jangz.pattern.command.aop.CglibProxy;
import com.jangz.pattern.command.entity.IProduct;
import com.jangz.pattern.command.entity.Light;

public class Test2 {

	public static void main(String[] args) {
		IProduct light = (IProduct) CglibProxy.getInstace(Light.class);

		Command command = new LightOnCommand(light);
		command.execute();
		command.undo();
	}

}
