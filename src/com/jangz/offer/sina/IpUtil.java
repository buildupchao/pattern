package com.jangz.offer.sina;

public class IpUtil {

	private static final int IPSIZE = 4;

	public static void main(String[] args) {
		int ip2Int = ip2Int("192.168.10.10");
		System.out.println(ip2Int); // -1062729206
		System.out.println(int2Ip(ip2Int)); // 192.168.10.10
	}

	public static int ip2Int(String ip) {

		String[] ipSeg = ip.split("\\.");
		if (ipSeg.length != IPSIZE) {
			return 0;
		}

		byte[] bytes = new byte[IPSIZE];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(ipSeg[i]);
		}
		return byte2Int(bytes);
	}

	private static int byte2Int(byte[] bytes) {
		int ip = 0, offset = 0xFF;

		for (int i = 0; i < bytes.length; i++) {
			ip |= (bytes[i] & offset);
			if (i < bytes.length - 1) {
				ip = ip << 8;
			}
		}
		return ip;
	}

	public static String int2Ip(int ip) {
		byte[] bytes = int2Byte(ip);
		StringBuilder ipStr = new StringBuilder("");

		for (int i = 0; i < IPSIZE; i++) {
			ipStr.append(Byte.toUnsignedInt(bytes[i])).append(".");
		}
		return ipStr.substring(0, ipStr.lastIndexOf("."));
	}

	private static byte[] int2Byte(int ip) {
		int offset = 0xFF;
		byte[] bytes = new byte[IPSIZE];

		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) ((ip >> ((IPSIZE - i - 1) * 8)) & offset);
		}

		return bytes;
	}
}
