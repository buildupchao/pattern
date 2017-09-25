package com.jangz.deepinspringmvc.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		ServerSocket server;
		try {
			server = new ServerSocket(8080);
			Socket socket = server.accept();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = in.readLine();
			System.out.println("received from client: " + line);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.write("received data: " + line);
			
			out.flush();
			out.close();
			in.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
