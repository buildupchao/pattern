package com.pattern.designpattern.apply.noifelse2;

public class NoIfElseWithPolymorphism {
	public static void main(String[] args) {
		MyPaper paper = new MyPaper();
		paper.choice(new Black());
	}
}
