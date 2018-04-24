package com.jangz.pattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeeklyLog implements Cloneable, Serializable {
	
	private static final long serialVersionUID = -7780463405250854353L;
	
	private String name;
	private String date;
	private String content;
	
	private Attachment attachement;
	
	@Override
	public WeeklyLog clone() {
		try {
			return (WeeklyLog) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public WeeklyLog deepClone() {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject(this);
			
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bis);
			return (WeeklyLog) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
