package com.pattern.tutor.netty.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.time.Instant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeServer {

	public static void main(String[] args) {
		int port = 8000;

		if (args != null && args.length == 1) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException ex) {
				log.error("Error here!!! NumberFormatException for Integer.parseInt#%s.", args[0]);
			}
		}

		ServerSocket server = null;

		try {
			server = new ServerSocket(port);
			log.info("The time server starts in port {}.", port);

			Socket socket = null;
			while (true) {
				socket = server.accept();
				new Thread(new TimeServerHandler(socket)).start();
			}
		} catch (IOException ex) {
			log.error("Error here!!!>>>>>>ServerSocket#{} error.", port, ex);
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				server = null;
			}
		}
	}

	static class TimeServerHandler implements Runnable {

		private static int counter;
		
		private Socket socket;

		public TimeServerHandler(Socket socket) {
			super();
			this.socket = socket;
		}

		@Override
		public void run() {
			BufferedReader in = null;
			PrintWriter out = null;
			
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream());
				
				String currentTime = null;
				String body = null;
				String command = null;
				
				for (int i = 0; i < 10; i++) {
					body = in.readLine();
					if (body == null
							|| (body.length() - System.getProperty("line.separator").length()) < 0) {
						break;
					}
					System.out.printf("Receive client[%s], counter is %d.", body, ++counter);
					
					command = body.substring(0, body.length() - System.getProperty("line.separator").length());
					currentTime = "READ TIME ORDER".equalsIgnoreCase(command) ? Timestamp.from(Instant.now()).toString() : "BAD ORDER";
					out.println(currentTime + System.getProperty("line.separator"));
				}
			} catch (IOException ex) {
		
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (out != null) {
					out.close();
					out = null;
				}
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
}
