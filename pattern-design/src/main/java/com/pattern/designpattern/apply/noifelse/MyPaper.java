package com.pattern.designpattern.apply.noifelse;

public class MyPaper {
	private PaperColor paperColor;

	public MyPaper(PaperColor paperColor) {
		super();
		this.paperColor = paperColor;
	}
	
	public PaperColor getPagerColor() {
		return this.paperColor;
	}
	
	public void choicePen() {
		this.paperColor.getPenColor();
	}
}
