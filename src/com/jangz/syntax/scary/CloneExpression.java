package com.jangz.syntax.scary;

import java.io.Serializable;

import com.jangz.syntax.scary.utils.CloneUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CloneExpression implements Cloneable, Serializable {

	private static final long serialVersionUID = 6744362368072382810L;

	private String name;
	private int age;
	private Heart heart;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return CloneUtils.clone(this);
	/*	CloneExpression exp = (CloneExpression) super.clone();
		exp.heart = (Heart) heart.clone();
		return exp;*/
	}

	public CloneExpression(String name, int age, int heartBeats) {
		super();
		this.name = name;
		this.age = age;
		this.heart = new Heart(heartBeats);
	}

	@Setter
	@AllArgsConstructor
	@ToString
	class Heart implements Cloneable, Serializable {
		private static final long serialVersionUID = -8705742675213537211L;
		
		int heartBeats = 10;

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return CloneUtils.clone(this);
		}
	}
}
