package com.jangz.pattern.adapter.newfeature;

public class AddableArrayAdapterExample {

	public static void main(String[] args) {
		Integer[] ia = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Short[] sa = new Short[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Long[] la = new Long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L };
		Float[] fa = new Float[] { 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f };
		Double[] da = new Double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0 };

		AddableArrayAdapter<Integer> aai = new AddableArrayAdapter<>(ia);
		AddableArrayAdapter<Short> aas = new AddableArrayAdapter<>(sa);
		AddableArrayAdapter<Long> aal = new AddableArrayAdapter<>(la);
		AddableArrayAdapter<Float> aaf = new AddableArrayAdapter<>(fa);
		AddableArrayAdapter<Double> aad = new AddableArrayAdapter<>(da);
		
		System.out.println("Integer sum: " + (aai.reduce()));
		System.out.println("Short sum: " + (aas.reduce()));
		System.out.println("Long sum: " + (aal.reduce()));
		System.out.println("Float sum: " + (aaf.reduce()));
		System.out.println("Double sum: " + aad.reduce());
	}
}
