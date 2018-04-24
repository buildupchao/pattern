package com.pattern.tutor.syntax.scary;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewInstanceExpression implements Cloneable, Serializable {

	private static final long serialVersionUID = -3445256424210992945L;
	
	private String name;
	private int age;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
