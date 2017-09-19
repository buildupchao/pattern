package com.jangz.deepinspringmvc.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NIOServer {

	public static void main(String[] args) {
		try {
			ServerSocketChannel channel = ServerSocketChannel.open();
			channel.socket().bind(new InetSocketAddress(8080));
			channel.configureBlocking(false);

			Selector selector = Selector.open();
			channel.register(selector, SelectionKey.OP_ACCEPT);
			// 创建处理器
			Handler handler = new Handler(1024);
			while (true) {
				if (selector.select(3000) == 0) {
					System.out.println("等待请求超时......");
					continue;
				}

				System.out.println("处理请求......");
				Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();

				while (keyIter.hasNext()) {
					SelectionKey key = keyIter.next();

					try {
						if (key.isAcceptable()) {
							handler.handleAccept(key);
						}
						if (key.isReadable()) {
							handler.handleRead(key);
						}
					} catch (IOException ex) {
						keyIter.remove();
						continue;
					}
					keyIter.remove();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class Handler {
		private int bufferSize = 1024;
		private String localCharset = "UTF-8";

		public Handler() {
		}

		public Handler(int bufferSize) {
			this(bufferSize, null);
		}

		public Handler(String localCharset) {
			this(-1, localCharset);
		}

		public Handler(int bufferSize, String localCharset) {
			if (bufferSize > 0) {
				this.bufferSize = bufferSize;
			}
			if (localCharset != null) {
				this.localCharset = localCharset;
			}
		}
		
		public void handleAccept(SelectionKey key) throws IOException {
			SocketChannel channel = ((ServerSocketChannel) key.channel()).accept();
			channel.configureBlocking(false);
			channel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
		}
		
		public void handleRead(SelectionKey key) throws IOException {
			SocketChannel channel = (SocketChannel) key.channel();
			ByteBuffer buffer = (ByteBuffer) key.attachment();
			buffer.clear();
			
			if (channel.read(buffer) == -1) {
				channel.close();
			} else {
				buffer.flip();
				String receivedStr = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
				System.out.println("received frm client: " + receivedStr);
				
				String respStr = "received data: " + receivedStr;
				buffer = ByteBuffer.wrap(respStr.getBytes(localCharset));
				channel.write(buffer);
				channel.close();
			}
		}
	}
}
