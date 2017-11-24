package com.jangz.algothinking.multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Algorithmeric {

	private static final Logger log = Logger.getLogger("Algorithmeric");

	BufferedReader reader;
	int orderNo;
	int[][] result;

	public Algorithmeric input() {
		reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			this.orderNo = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			log.warning("Read data from console input generates an NumberFormatException.");
		} catch (IOException e) {
			log.warning("Open Input stream generates an IOException.");
		}
		return this;
	}

	public Algorithmeric calculate() {
		result = new int[orderNo][];

		for (int row = 0; row < result.length; row++) {
			result[row] = new int[row + 1];
			for (int col = 0; col < result[row].length; col++) {
				result[row][col] = (row + 1) * (col + 1);
			}
		}

		return this;
	}

	public void print() {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print((i + 1) + "*" + (j + 1) + " = " + result[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new Algorithmeric().input().calculate().print();
	}
}
