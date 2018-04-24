package com.pattern.designpattern.proxy.simple;

import com.pattern.designpattern.proxy.beans.Laundry;

public class LaundryProxy implements Laundry {

	private Laundry laundry;

	public LaundryProxy(Laundry laundry) {
		this.laundry = laundry;
	}

	public void setLaundry(Laundry laundry) {
		this.laundry = laundry;
	}
	
	public String getLaundryName() {
		if (this.laundry != null)
			return this.laundry.getClass().getSimpleName();
		return null;
	}
	
	@Override
	public void wash() {
		this.laundry.wash();
	}

	@Override
	public void dryCleaning() {
		this.laundry.dryCleaning();
	}

}
