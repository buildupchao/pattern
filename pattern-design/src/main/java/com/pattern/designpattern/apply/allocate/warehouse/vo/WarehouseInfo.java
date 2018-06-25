package com.pattern.designpattern.apply.allocate.warehouse.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WarehouseInfo implements Serializable, Comparable<WarehouseInfo> {
	private static final long serialVersionUID = 5764511510985881717L;
	
	int whNo;
	String shortName;
	String name;
	String city;
	String state;
	String zipcode;
	String country;
	int priority;
	String geo;
	Timestamp cutOff;

	@Override
	public int compareTo(WarehouseInfo o) {
		return this.getWhNo() - o.getWhNo();
	}
}
