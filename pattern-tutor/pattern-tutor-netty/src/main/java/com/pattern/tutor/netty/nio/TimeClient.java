package com.pattern.tutor.netty.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeClient {
	
	private static int counter;
	
	public static void main(String[] args) {
		String host = "localhost";
		int port = 8000;
		
		if (args != null && args.length == 1) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException ex) {
				log.error("Error here!!! NumberFormatException for Integer.parseInt#{}.", args[0], ex);
			}
		} else if (args != null && args.length == 2) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException ex) {
				log.error("Error here!!! NumberFormatException for Integer.parseInt#{}.", args[0], ex);
			}
			host = args[1];
		}
		log.info("Listen to {}:{}.", host, port);
		
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			socket = new Socket(host, port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			for (int i = 0; i < 10; i++) {
				out.println("READ TIME ORDER" + System.getProperty("line.separator"));
				System.out.println("Send READ TIME ORDER to server is ok!");
				
				String resp = in.readLine();
				System.out.printf("Receive server[%s], counter is %d.\n", resp, (++counter));
			}
		} catch (IOException ex) {
			log.error("Error here!!! BufferedReader#readLine error.", ex);
		} finally {
			if (out != null) {
				out.close();
				out = null;
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				socket = null;
			}
		}
	}
}
