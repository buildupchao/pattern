package com.pattern.tutor.syntax.core;

import java.io.Serializable;
import java.util.Objects;

public class InstanceExample implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 2928459354216927912L;
	final String name = "instance";
	final int num = 16;
	
	@Override
	public int hashCode() {
		return Objects.hash(name, num);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		InstanceExample current = (InstanceExample) obj;
		return Objects.equals(this.name, current.name)
				&& Objects.equals(this.num, current.num);
	}
	
	@Override
	protected Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
