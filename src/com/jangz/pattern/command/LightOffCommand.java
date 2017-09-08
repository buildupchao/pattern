package com.jangz.pattern.command;

import com.jangz.pattern.command.entity.IProduct;

public class LightOffCommand implements Command {

	private IProduct light;
	
	public LightOffCommand(IProduct light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.off();
	}

	@Override
	public void undo() {
		light.on();
	}

}
