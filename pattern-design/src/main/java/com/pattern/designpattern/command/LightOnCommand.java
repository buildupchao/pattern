package com.pattern.designpattern.command;

import com.pattern.designpattern.command.entity.IProduct;

public class LightOnCommand implements Command {

	private IProduct light;

	public LightOnCommand(IProduct light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

	@Override
	public void undo() {
		light.off();
	}

}
