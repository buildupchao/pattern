package com.jangz.pattern.command.entity;

import com.jangz.pattern.command.stereotype.MethodReport;

public interface IProduct {
	@MethodReport
	public void on();
	
	@MethodReport
	public void off();
}
