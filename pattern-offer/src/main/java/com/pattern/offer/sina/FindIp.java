package com.pattern.offer.sina;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class FindIp {
	
	private static final String BASEPATH = "src/main/java/com/pattern/offer/sina";
	
	public static void main(String[] args) throws IOException {
//		generateIp();
		
		commonFind();
//		fastFind();
	}
	
	private static void commonFind() throws IOException {
		long startTime = System.currentTimeMillis();
		String waitToFindIp = "91.149.5.68";
		boolean hasIp = Files.lines(Paths.get(BASEPATH + "/ips.txt"))
				.filter(ip -> ip.contains(waitToFindIp))
				.findAny()
				.isPresent() ? true : false;
		long endTime = System.currentTimeMillis();
		System.out.println("Cost: " + ((endTime - startTime) / 1000.0) + "\t" + hasIp);
	}
	
	private static void fastFind() throws IOException {
		long startTime = System.currentTimeMillis();
		String waitToFindIp = "91.149.5.68";
		boolean hasIp = Files.lines(Paths.get(BASEPATH + "/ips.txt"))
				.sorted()
				.filter(ip -> ip.contains(waitToFindIp))
				.findAny()
				.isPresent() ? true : false;
		long endTime = System.currentTimeMillis();
		System.out.println("Cost: " + ((endTime - startTime) / 1000.0) + "\t" + hasIp);
	}
	
	private static void generateIp() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(BASEPATH + "/ips.txt")));
		Random rand = new Random(255);
		String[] ips = new String[90_000];
		for (int i = 0; i < 90_000; i++) {
			ips[i] = rand.nextInt(255) + "." + rand.nextInt(255) + "." + rand.nextInt(255) + "." + rand.nextInt(255);
			out.write(ips[i] + "\n");
			System.out.println(ips[i]);
		}
		out.close();
	}
}
