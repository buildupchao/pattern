package com.pattern.tutor.syntax.net;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

public class LookUpExample {

	public static void main(String[] args) {
		System.out.println(ipWithDomain("185.199.108.153"));
	}

	public static String ipWithDomain(String host) {
		String ipWithDomain = host;
		if (!isDomain(host)) {
			try {
				InetAddress address = Inet4Address.getByName(host);
				String hostName = address.getHostName();
				if (!hostName.equals(host)) {
					ipWithDomain = host + "(" + hostName + ")";
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		return ipWithDomain;
	}
	
	private static boolean isDomain(String host) {
		String[] segments = host.split("\\.");
		if (segments.length == 4) {
			for (String segment : segments) {
				if (!isNumeric(segment)) {
					return true;
				}
			}
			return false;
		} else {
			return true;
		}
	}
	
	private static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
}
