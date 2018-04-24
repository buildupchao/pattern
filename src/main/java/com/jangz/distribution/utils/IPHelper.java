package com.jangz.distribution.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPHelper {

	public static String localIp() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
}
