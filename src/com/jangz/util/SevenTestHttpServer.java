package com.jangz.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class SevenTestHttpServer {
	
	public static void main(String[] args) {
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(8888), 0);
			server.createContext("/synnex", new HttpHandler() {
				
				@Override
				public void handle(HttpExchange t) throws IOException {
					InputStream is = t.getRequestBody();
					String response = "<h3>Happy In Synnex 2017!</h3>";
					t.sendResponseHeaders(200, response.length());
					OutputStream os = t.getResponseBody();
					os.write(response.getBytes());
					os.close();
				}
			});
			server.setExecutor(null);
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
