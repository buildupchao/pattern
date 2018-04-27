package com.pattern.tutor.syntax.collection.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Message {

	public static final int KEY_MSG = 1;
	public static final int MOUSE_MSG = 2;
	public static final int SYS_MSG = 3;

	private Object source;
	private int type;
	private String info;
}
