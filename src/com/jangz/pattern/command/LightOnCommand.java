package com.jangz.pattern.command;

import com.jangz.pattern.command.entity.IProduct;

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
