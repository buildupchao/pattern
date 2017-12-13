package com.jangz.pattern.factory.newfeature;

import java.io.Serializable;

public class CountRecoder implements Serializable {

	private static final long serialVersionUID = -1198742494126059767L;

	private int countOfFirstStage;
	private int countOfSecondStage;
	private int countOfThirdStage;
	private int countOfForthStage;
	private int countOfFifthStage;
	private int countOfSixthStage;

	public int getCountOfFirstStage() {
		return countOfFirstStage;
	}

	public void setCountOfFirstStage(int countOfFirstStage) {
		this.countOfFirstStage = countOfFirstStage;
	}

	public int getCountOfSecondStage() {
		return countOfSecondStage;
	}

	public void setCountOfSecondStage(int countOfSecondStage) {
		this.countOfSecondStage = countOfSecondStage;
	}

	public int getCountOfThirdStage() {
		return countOfThirdStage;
	}

	public void setCountOfThirdStage(int countOfThirdStage) {
		this.countOfThirdStage = countOfThirdStage;
	}

	public int getCountOfForthStage() {
		return countOfForthStage;
	}

	public void setCountOfForthStage(int countOfForthStage) {
		this.countOfForthStage = countOfForthStage;
	}

	public int getCountOfFifthStage() {
		return countOfFifthStage;
	}

	public void setCountOfFifthStage(int countOfFifthStage) {
		this.countOfFifthStage = countOfFifthStage;
	}

	public int getCountOfSixthStage() {
		return countOfSixthStage;
	}

	public void setCountOfSixthStage(int countOfSixthStage) {
		this.countOfSixthStage = countOfSixthStage;
	}

}
