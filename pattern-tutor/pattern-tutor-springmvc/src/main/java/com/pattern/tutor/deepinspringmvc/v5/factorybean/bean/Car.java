package com.pattern.tutor.deepinspringmvc.v5.factorybean.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	private String brand;
	private int maxSpeed;
	private double price;
}
