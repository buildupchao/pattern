package com.pattern.tutor.deepinspringmvc.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) {
		String msg = "Hello, server!";
		try {
			Socket socket = new Socket("127.0.0.1", 8080);
			
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			writer.println(msg);
			writer.flush();
			
			String line = reader.readLine();
			System.out.println("received from server: " + line);
			
			writer.close();
			reader.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
