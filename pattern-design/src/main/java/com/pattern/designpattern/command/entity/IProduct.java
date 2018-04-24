package com.pattern.designpattern.command.entity;

import com.pattern.designpattern.command.stereotype.MethodReport;

public interface IProduct {
	@MethodReport
	public void on();
	
	@MethodReport
	public void off();
}
