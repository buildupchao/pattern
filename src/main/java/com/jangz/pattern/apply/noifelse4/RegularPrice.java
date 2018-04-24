package com.jangz.pattern.apply.noifelse4;

public class RegularPrice extends Price {

	@Override
	public double getCharge(int days) {
		double result = 2;
		
		if (days > 2) {
			result += (days - 2) * 1.5;
		}
		return result;
	}

	@Override
	public double getIntegral(int days) {
		return days * 2;
	}

}
