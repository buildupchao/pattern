package com.pattern.designpattern.apply.noifelse4;

public class Movie {

	private static final String PACKAGE_BASE = "com.jangz.pattern.apply.noifelse4.";
	public static final String REGULAR = PACKAGE_BASE + "RegularPrice";
	public static final String NEW_RELEASE = PACKAGE_BASE + "NewRelease";
	public static final String CHILDREN = PACKAGE_BASE + "ChildrenPrice";

	private Price price;

	public Price getPrice() {
		return price;
	}

	public void setPrice(String movieClass) throws MovieException {
		try {
			Class<?> cls = Class.forName(movieClass);
			this.price = (Price) cls.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new MovieException("Movie doesn't exist.");
		}
	}

}
