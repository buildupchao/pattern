package com.jangz.deepinspringmvc.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class HttpServer {

	public static void main(String[] args) {
		try {
			ServerSocketChannel channel = ServerSocketChannel.open();
			channel.socket().bind(new InetSocketAddress(80));
			channel.configureBlocking(false);

			Selector selector = Selector.open();
			channel.register(selector, SelectionKey.OP_ACCEPT);
			// 创建处理器
			while (true) {
				if (selector.select(3000) == 0) {
					continue;
				}
				// 获取待处理的SelectionKey
				Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
				while (keyIter.hasNext()) {
					SelectionKey key = keyIter.next();
					new Thread(new HttpHandler(key)).start();
					// 处理完成后，从待处理的SelectionKey迭代器中移除当前所使用的key
					keyIter.remove();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class HttpHandler implements Runnable {
		private int bufferSize = 1024;
		private String localCharset = "UTF-8";
		private SelectionKey key;

		public HttpHandler(SelectionKey key) {
			super();
			this.key = key;
		}

		public void handleAccept() throws IOException {
			SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
			clientChannel.configureBlocking(false);
			clientChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
		}

		public void handleRead() throws IOException {
			// 获取channel
			SocketChannel socketChannel = (SocketChannel) key.channel();
			// 获取buffer并重置
			ByteBuffer buffer = (ByteBuffer) key.attachment();
			buffer.clear();

			// 没有读到内容则关闭
			if (socketChannel.read(buffer) == -1) {
				socketChannel.close();
			} else {
				// 接受请求数据
				buffer.flip();
				String receivedString = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
				// 控制台打印请求报文头
				String[] requestMessage = receivedString.split("\r\n");
				for (String s : requestMessage) {
					System.out.println(s);
					// 遇到空行说明报文头已经打印完
					if (s.isEmpty()) {
						break;
					}
				}

				// 控制台打印首行信息
				String[] firstLine = requestMessage[0].split(" ");
				System.out.println();
				System.out.println("Method:\t" + firstLine[0]);
				System.out.println("url:\t" + firstLine[1]);
				System.out.println("HTTP Version:\t" + firstLine[2]);
				System.out.println();

				// 返回客户端
				StringBuilder sendString = new StringBuilder();
				sendString.append("HTTP/1.1 200 OK\r\n"); // 响应报文首行，200表示处理成功
				sendString.append("Content-Type:text/html;charset=" + localCharset + "\r\n");
				sendString.append("\r\n"); // 报文头结束后加一个空行

				sendString.append("<html><head><title>显示报文</title></head><body>");
				sendString.append("接收到请求报文是:<br/>");
				for (String s : requestMessage) {
					sendString.append(s + "<br/>");
				}
				sendString.append("</body></html>");
				buffer = ByteBuffer.wrap(sendString.toString().getBytes(localCharset));
				socketChannel.write(buffer);
				socketChannel.close();

			}
		}

		@Override
		public void run() {
			try {
				// 接收到连接请求时
				if (key.isAcceptable()) {
					handleAccept();
				}
				if (key.isReadable()) {
					handleRead();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
