package com.pattern.distribution.net.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import com.pattern.common.utils.PrintlnUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NIOChannelExample {

	private static final String PREFIX = System.getProperty("user.dir") + File.separator + "src/com/jangz/net/nio";
	private static final String SRC = PREFIX + File.separator + "src.log";
	private static final String DEST = PREFIX + File.separator + "dest.log";
	
	public static void tryFileChannel() {
		try {
			File destFile = new File(DEST);
			if (destFile.exists())
				destFile.delete();
			
			FileInputStream in = new FileInputStream(SRC);
			FileChannel inChannel = in.getChannel();
			
			FileOutputStream out = new FileOutputStream(DEST);
			FileChannel outChannel = out.getChannel();
			
			inChannel.transferTo(0, inChannel.size(), outChannel);
			
			log.info("Copy file is OK!");
			
			in.close();
			inChannel.close();
			out.close();
			outChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void channelRW() {
		try {
			FileInputStream in = new FileInputStream(SRC);
			FileChannel inChannel = in.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while (inChannel.read(buffer) != -1) {
				buffer.flip();
				println(buffer);
				buffer.clear();
			}
			in.close();
			inChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void println(ByteBuffer buffer) {
		byte[] bytes = new byte[buffer.remaining()];
		int i = 0;
		while (buffer.hasRemaining())
			bytes[i++] = buffer.get();
		PrintlnUtils.println(new String(bytes, Charset.defaultCharset()));
	}
	
	public static void main(String[] args) {
//		tryFileChannel();
		channelRW();
	}
}
