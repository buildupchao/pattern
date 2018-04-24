package com.jangz.pattern.apply.noifelse4;

public class NewReleasePrice extends Price {

	@Override
	public double getCharge(int days) {
		return days * 3;
	}

	@Override
	public double getIntegral(int days) {
		return days * 3;
	}

}
