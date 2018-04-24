package com.pattern.designpattern.apply.noifelse4;

public class ChildrentPrice extends Price {

	@Override
	public double getCharge(int days) {
		double result = 1.5;

		if (days > 3) {
			result += (days - 3) * 1.5;
		}
		return result;

	}

	@Override
	public double getIntegral(int days) {
		return days * 1.5;
	}

}
